package com.foodrunner.ui.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.ConnectivityManager
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.foodrunner.R
import com.foodrunner.api.FoodRunnerService
import com.foodrunner.db.AppDatabase
import com.foodrunner.db.RoomDao
import com.foodrunner.model.Food
import com.foodrunner.model.RestaurantDetailsResponse
import com.foodrunner.ui.adapter.RestaurantDetailsAdapter
import kotlinx.android.synthetic.main.activity_restaurant_details.*
import kotlinx.android.synthetic.main.activity_restaurant_details.rl_retry
import kotlinx.android.synthetic.main.activity_restaurant_details.txt_retry
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.sql.SQLException

class RestaurantDetailsActivity : AppCompatActivity() {

    var restaurantId = ""
    var restaurantName = ""
    var restaurantImage = ""

    var isFav : Boolean = false
    var restaurantDetailsList : ArrayList<RestaurantDetailsResponse.Data.MenuData> = ArrayList()
    var foodList : ArrayList<Food> = ArrayList()


    lateinit var dao: RoomDao
    lateinit var prefs: SharedPreferences
    var BASE_URL = "http://13.235.250.119/"
    lateinit var httpClient: OkHttpClient.Builder
    lateinit var retrofit: Retrofit
    lateinit var restaurantDetailsAdapter: RestaurantDetailsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_details)


        //supportActionBar?.hide()

        dao = AppDatabase.getInstance(this).RoomDao()
        prefs = getSharedPreferences("Food Runner", Context.MODE_PRIVATE)!!


        httpClient = OkHttpClient.Builder()
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        supportActionBar?.hide()

        restaurantId = intent.getStringExtra("restaurantId")?:""
        restaurantName = intent.getStringExtra("restaurantName")?:""
        isFav =intent.getBooleanExtra("isFav",false)
        restaurantImage = intent.getStringExtra("imageUrl")?:""

        //Glide.with(this).load(restaurantImage).apply(RequestOptions.centerCropTransform()).into(ivRestaurantImg)

        supportActionBar?.title = restaurantName
        supportActionBar?.setDisplayHomeAsUpEnabled(true)



        if(isInternetAvailable()) {
            getMenu(restaurantId)
            rlRetry.visibility = View.GONE
        }
        else{
            rlRetry.visibility = View.VISIBLE

        }
        clearCart()
        initRecyclerView()


        btnViewCart.setOnClickListener{
            val intent = Intent(this, CartActivity::class.java)
            intent.putExtra("restaurantId",restaurantId)
            intent.putExtra("restaurantName",restaurantName)
            intent.putExtra("imageUrl",restaurantImage)
            startActivity(intent)
        }

        tvRetry.setOnClickListener {
            if(isInternetAvailable()){
                getMenu(restaurantId)
                tvRetry.visibility = View.GONE
            }
        }


    }


    private fun isInternetAvailable():Boolean{
        val conf = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val info = conf.activeNetworkInfo

        if(info == null || !info.isConnected || !info.isAvailable) {
            Toast.makeText(this, "No Internet Connection ",Toast.LENGTH_SHORT).show()
            return false
        }else
            return true
    }



    private fun clearCart() {

        AddRemoveToCart(
            this
            , RestaurantDetailsResponse.Data.MenuData("", "", "", ""),
            "Clear"
        ).execute()

    }




    private fun initRecyclerView() {
        restaurantDetailsAdapter = restaurantDetailsList.let { it ->
            RestaurantDetailsAdapter(this, it, object : RestaurantDetailsAdapter.OnItemClickListener {

                @SuppressLint("SetTextI18n")
                override fun onItemClick(position: Int, view: View) {

                    var c=0
                    val btnAdd = view as Button
                    foodList.forEach {it1->
                        if(it1.foodItemId == it[position].id)
                            c=1
                    }
                    if(c==1){
                        btnAdd.background = getDrawable(R.drawable.my_btn_add)

                        removeFromDb(it[position])
                        foodList.remove(Food(it[position].id))

                    }else{
                        btnAdd.background = getDrawable(R.drawable.my_btn_remove)

                        addToDb(it[position])
                        foodList.add(Food(it[position].id))
                    }

                    if(foodList.isNotEmpty())
                        btnViewCart.visibility = View.VISIBLE
                    else
                        btnViewCart.visibility = View.GONE


                }

                override fun onFavClick(position: Int, view: View) {

                }


            })
        }
        rvMenu.apply {
            adapter = restaurantDetailsAdapter
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }
    }


    private fun addToDb(food: RestaurantDetailsResponse.Data.MenuData) {

        AddRemoveToCart(this, food, "Add").execute()

    }

    private fun removeFromDb(food: RestaurantDetailsResponse.Data.MenuData) {

        AddRemoveToCart(this, food, "Remove")
            .execute()

    }

    private fun getMenu(restaurantId: String) {

        val  api= retrofit.create(FoodRunnerService::class.java)

        val call =api.getMenuList(restaurantId)

        call.enqueue(object : Callback<RestaurantDetailsResponse> {
            override fun onFailure(call: Call<RestaurantDetailsResponse>, t: Throwable) {
                //Toast.makeText(this ,"On failure",Toast.LENGTH_SHORT).show()
                Log.i("h","on fail"+t.toString())
            }

            override fun onResponse(
                call: Call<RestaurantDetailsResponse>,
                response: retrofit2.Response<RestaurantDetailsResponse>
            ) {
                Log.i("d",response.body().toString())
                response.body()?.data?.data?.forEach {
                    restaurantDetailsList.add(it!!)
                }

                restaurantDetailsAdapter.notifyDataSetChanged()

            }
        })
    }

    private class AddRemoveToCart(
        private var context: Context?,
        private var restaurantDetailsData: RestaurantDetailsResponse.Data.MenuData,
        private var param: String
    ) : AsyncTask<Void, Void, RestaurantDetailsResponse.Data.MenuData>() {

        var dao: RoomDao =AppDatabase.getInstance(context!!).RoomDao()

        override fun onPostExecute(result: RestaurantDetailsResponse.Data.MenuData?) {
            super.onPostExecute(result)

            if(result!=null) {
               // Toast.makeText(context, "Added to Cart", Toast.LENGTH_SHORT).show()
            }
        }

        override fun doInBackground(vararg url: Void): RestaurantDetailsResponse.Data.MenuData {
            var c=0
            try {
                when (param) {
                    "Add" -> dao.addToCart(restaurantDetailsData)
                    "Remove" -> dao.removeFromCart(restaurantDetailsData)
                    "Clear" -> dao.clearCart()
                }

            }
            catch (e : SQLException) {
                Toast.makeText(context, "Error : $e", Toast.LENGTH_SHORT).show()
                c=1
            }
            return if(c==1)
                RestaurantDetailsResponse.Data.MenuData("","","","")
            else
                restaurantDetailsData
        }
    }

}
