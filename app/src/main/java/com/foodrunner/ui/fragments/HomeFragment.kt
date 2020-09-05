package com.foodrunner.ui.fragments

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.ConnectivityManager
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.foodrunner.R
import com.foodrunner.api.FetchRestaurantDetailResponse
import com.foodrunner.api.FoodRunnerService
import com.foodrunner.db.AppDatabase
import com.foodrunner.db.RoomDao
import com.foodrunner.model.FavoriteModel
import com.foodrunner.ui.activities.RestaurantDetailsActivity
import com.foodrunner.ui.adapter.RestaurantsAdapter
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.dialog_share.view.*
import kotlinx.android.synthetic.main.fragment_home.*
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.sql.SQLException


class HomeFragment : Fragment() {

    var favoriteList : List<FavoriteModel> = ArrayList()

    lateinit var restaurantsAdapter: RestaurantsAdapter
    val restaurantList = ArrayList<FetchRestaurantDetailResponse.Data.InternalData>()

    lateinit var dao: RoomDao
    lateinit var prefs: SharedPreferences
    var BASE_URL = "http://13.235.250.119/"
    lateinit var httpClient: OkHttpClient.Builder
    lateinit var retrofit: Retrofit

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)



        dao = AppDatabase.getInstance(context!!).RoomDao()
        prefs = activity?.getSharedPreferences("Food Runner", Context.MODE_PRIVATE)!!


        httpClient = OkHttpClient.Builder()

        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        GetFavoriteList(context).execute()
        if(isInternetAvailable()) {
            apiCall()
            rl_retry.visibility =GONE

        }
        else{
            rl_retry.visibility = VISIBLE
        }


        restaurantsAdapter = restaurantList.let { it ->
            RestaurantsAdapter(context, it, object : RestaurantsAdapter.OnItemClickListener {
                override fun onShareClick(position: Int, view: View) {
                    val share = Intent(Intent.ACTION_SEND)
                    share.putExtra(Intent.EXTRA_TEXT, "Are You Hungry,TRY US! " + it[position].name +
                            " Our rating is " + it[position].rating)
                    share.type = "text/plain"
                    context?.startActivity(Intent.createChooser(share, "Share Via"))
                }

                override fun onFavClick(position: Int, view: View) {
                    val v = view as ImageView

                        if (it[position].isFav ==null || !it[position].isFav!!) {
                            it[position].isFav = true
                            restaurantsAdapter.notifyDataSetChanged()
                            addToDb(it[position])
                            v.setImageResource(R.drawable.ic_fill_fav)
                        }
                        else if(!it[position].isFav!!) {
                            it[position].isFav = true
                            restaurantsAdapter.notifyDataSetChanged()
                            addToDb(it[position])
                            v.setImageResource(R.drawable.ic_fill_fav)
                        }else {
                            it[position].isFav = false
                            restaurantsAdapter.notifyDataSetChanged()
                            removeFromDb(it[position])
                            v.setImageResource(R.drawable.ic_not_fav)
                        }

                }

                override fun onItemClick(position: Int, view: View) {
                    val intent = Intent(context,
                        RestaurantDetailsActivity::class.java)
                    intent.putExtra("restaurantId", it[position].id)
                    intent.putExtra("restaurantName", it[position].name)
                    intent.putExtra("isFav", it[position].isFav)
                    intent.putExtra("imageUrl", it[position].imageUrl)
                    startActivity(intent)
                }
            })
        }
        rvRestaurants.apply {
            adapter = restaurantsAdapter
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }


        txt_retry.setOnClickListener {
            if(isInternetAvailable()){
                apiCall()
                rl_retry.visibility = GONE
            }
        }
    }


    private fun addToDb(restaurantDetail: FetchRestaurantDetailResponse.Data.InternalData) {
        val favoriteModel = FavoriteModel(prefs.getString("phone","")?:""
            ,restaurantDetail.id?:"",restaurantDetail.name,restaurantDetail.rating,restaurantDetail.costForOne
        ,restaurantDetail.imageUrl)

        AddFavoriteAsyncTask(context, favoriteModel,"Add").execute()

    }

    private fun removeFromDb(restaurantDetail: FetchRestaurantDetailResponse.Data.InternalData) {
        val favoriteModel = FavoriteModel(prefs.getString("phone","")?:""
            ,restaurantDetail.id?:"",restaurantDetail.name,restaurantDetail.rating,restaurantDetail.costForOne
            ,restaurantDetail.imageUrl)

        AddFavoriteAsyncTask(context, favoriteModel,"Remove").execute()

    }

    private fun isInternetAvailable():Boolean{
        val conf = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val info = conf.activeNetworkInfo

        if(info == null || !info.isConnected || !info.isAvailable) {
            Toast.makeText(context, "No Internet Connection ",Toast.LENGTH_SHORT).show()
            return false
        }else
            return true
    }

    private fun apiCall() {


        /**
        I have used retrofit library instead of Volley library as my teacher suggested to use this library,
        so I tried using it.
        I have also used Volley Library after learning through Internshala videos but I have commented that code
        MainActivity :: Line 166

         */


        val  api= retrofit.create(FoodRunnerService::class.java)

        val call =api.getRestaurantList()

        call.enqueue(object : Callback<FetchRestaurantDetailResponse> {
            override fun onFailure(call: Call<FetchRestaurantDetailResponse>, t: Throwable) {
                //Toast.makeText(this ,"On failure",Toast.LENGTH_SHORT).show()
                Log.i("h","on fail"+t.toString())
            }

            override fun onResponse(
                call: Call<FetchRestaurantDetailResponse>,
                response: retrofit2.Response<FetchRestaurantDetailResponse>
            ) {
                Log.i("d",response.body().toString())
                restaurantList.clear()
                response.body()?.data?.data?.forEach {
                    restaurantList.add(it!!)
                }



                if(favoriteList.isNotEmpty()) {
                    favoriteList.forEach { favoriteRestaurant ->
                        restaurantList.forEach { it1 ->
                            if(favoriteRestaurant.id == it1.id && favoriteRestaurant.mobileNumber == prefs.getString("phone",""))
                                it1.isFav = true
                        }

                    }

                }
            when {
                prefs.getString("SortParam","")=="Cost" -> sortRestaurantsList("Cost")
                prefs.getString("SortParam","")=="Rating" -> sortRestaurantsList("Rating")
                prefs.getString("SortParam","")=="" -> sortRestaurantsList("")
            }

                //prefs.edit().remove("SortParam").apply()
                restaurantsAdapter.notifyDataSetChanged()

            }
        })
    }

    private fun sortRestaurantsList(sortParam: String) {

        when (sortParam) {
            "Cost" -> {
                restaurantList.sortBy { it.id?.toInt() }
                restaurantList.sortBy { it.costForOne?.toInt() }
                restaurantsAdapter.notifyDataSetChanged()
            }
            "Rating"->{
                restaurantList.sortBy { it.id?.toInt() }
                restaurantList.sortBy { it.rating?.toDouble() }
                restaurantList.reverse()
                restaurantsAdapter.notifyDataSetChanged()
            }
            "" ->{
                restaurantList.sortBy { it.id?.toInt() }
                restaurantsAdapter.notifyDataSetChanged()
            }
        }


    }

    fun showShareChooser(
        popupWindow: BottomSheetDialog?,
        fragment: HomeFragment,
        layout: Int,
        restaurantDetails: FetchRestaurantDetailResponse.Data.InternalData
    ): BottomSheetDialog? {

        val popupView = LayoutInflater.from(fragment.context).inflate(layout, null)
        popupWindow?.setContentView(popupView)
        popupWindow?.show()

        popupView.flWhatsapp?.setOnClickListener {
            popupWindow?.dismiss()
            sendMessage(it,"Whatsapp",restaurantDetails)

        }

        popupView.flInsta?.setOnClickListener {
            popupWindow?.dismiss()
            sendMessage(it,"Instagram",restaurantDetails)

        }
        return popupWindow

    }

    fun sendMessage(
        view: View,
        platform: String,
        restaurantDetails: FetchRestaurantDetailResponse.Data.InternalData
    ) {

        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        val text = "Hey, Try food from "+ restaurantDetails.name +
                "and its rating is " +restaurantDetails.rating +". Enjoy your food!! "
        // change with required  application package

        if(platform =="Whatsapp")
            intent.setPackage("com.whatsapp")
        else if(platform =="Instagram")
            intent.setPackage("com.instagram.android")

        intent.putExtra(Intent.EXTRA_TEXT, text)
        startActivity(Intent.createChooser(intent, text))
    }


    private class AddFavoriteAsyncTask(
        private var context: Context?,
        private var favoriteModel: FavoriteModel,
        private var param: String
    ) : AsyncTask<Void, Void, FavoriteModel>() {

         var dao: RoomDao= AppDatabase.getInstance(context!!).RoomDao()

        override fun onPostExecute(result: FavoriteModel?) {
            super.onPostExecute(result)

            if(result!=null) {
                if(param == "Add")
                    Toast.makeText(context, "Added to favorite", Toast.LENGTH_SHORT).show()
                else if(param == "Remove")
                    Toast.makeText(context, "Removed from favorite", Toast.LENGTH_SHORT).show()
            }
        }

        override fun doInBackground(vararg url: Void): FavoriteModel {
            var c=0
            try {
                if(param == "Add")
                    dao.addToFavorite(favoriteModel)
                else if(param == "Remove")
                    dao.removeFromFav(favoriteModel)


            }
            catch (e : SQLException) {
                Toast.makeText(context, "Error : $e", Toast.LENGTH_SHORT).show()
                c=1
            }
            return if(c==1)
                FavoriteModel("","")
            else
                favoriteModel
        }
    }



    inner class GetFavoriteList(
        private var context: Context?
    ) : AsyncTask<Void, Void, List<FavoriteModel>>() {

        var dao: RoomDao= AppDatabase.getInstance(context!!).RoomDao()


        override fun onPostExecute(result: List<FavoriteModel>) {
            if(result.isNotEmpty()) {
                favoriteList = result
            }
            super.onPostExecute(result)

        }

        override fun doInBackground(vararg url: Void): List<FavoriteModel> {
            var c=0
            var favoriteRestaurantList : ArrayList<FavoriteModel> = ArrayList()
            try {
                dao.getFavoriteRestaurantList().forEach {
                    if(it.mobileNumber == prefs.getString("phone",""))
                        favoriteRestaurantList.add(it)
                }
            }
            catch (e : SQLException) {
                Toast.makeText(context, "Error : $e", Toast.LENGTH_SHORT).show()
                c=1
            }
            return if(c==1)
                ArrayList()
            else
                favoriteRestaurantList
        }
    }

}


