package com.foodrunner.ui.fragments

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.AsyncTask
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.foodrunner.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.foodrunner.api.FetchRestaurantDetailResponse
import com.foodrunner.db.AppDatabase
import com.foodrunner.db.RoomDao
import com.foodrunner.model.FavoriteModel
import com.foodrunner.ui.activities.RestaurantDetailsActivity
import com.foodrunner.ui.adapter.RestaurantsAdapter
import kotlinx.android.synthetic.main.fragment_favorites.*
import java.sql.SQLException
import kotlin.collections.ArrayList

class FavoritesFragment : Fragment() {
    var favoriteList: List<FavoriteModel> = ArrayList()

    lateinit var restaurantsAdapter: RestaurantsAdapter
    val restaurantList = ArrayList<FetchRestaurantDetailResponse.Data.InternalData>()
    lateinit var dao: RoomDao
    lateinit var prefs: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_favorites, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        GetFavoriteList(context).execute()

        setHasOptionsMenu(false)

        dao = AppDatabase.getInstance(context!!).RoomDao()
        prefs = activity?.getSharedPreferences("Food Runner", Context.MODE_PRIVATE)!!


        restaurantsAdapter = restaurantList.let { it ->
            RestaurantsAdapter(context, it, object : RestaurantsAdapter.OnItemClickListener {
                override fun onShareClick(position: Int, view: View) {
                    val share = Intent(Intent.ACTION_SEND)
                    share.putExtra(
                        Intent.EXTRA_TEXT, "Food is calling you.?TRY US! " + it[position].name +
                                " Our rating is " + it[position].rating
                    )
                    share.type = "text/plain"
                    context?.startActivity(Intent.createChooser(share, "Share via"))
                }

                override fun onFavClick(position: Int, view: View) {
                    val v = view as ImageView

                    if (it[position].isFav == null || !it[position].isFav!!) {
                        it[position].isFav = true
                        restaurantsAdapter.notifyDataSetChanged()
                        addToDb(it[position])
                        v.setImageResource(R.drawable.ic_fill_fav)
                    } else if (!it[position].isFav!!) {
                        it[position].isFav = true
                        restaurantsAdapter.notifyDataSetChanged()
                        addToDb(it[position])
                        v.setImageResource(R.drawable.ic_fill_fav)
                    } else {
                        it[position].isFav = false
                        restaurantsAdapter.notifyDataSetChanged()
                        removeFromDb(it[position])
                        v.setImageResource(R.drawable.ic_not_fav)
                    }
                }

                override fun onItemClick(position: Int, view: View) {
                    val intent = Intent(context, RestaurantDetailsActivity::class.java)
                    intent.putExtra("restaurantId", it[position].id)
                    intent.putExtra("restaurantName", it[position].name)
                    intent.putExtra("isFav", it[position].isFav)
                    startActivity(intent)
                }
            })
        }
        rvFav.apply {
            adapter = restaurantsAdapter
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }
    }


    private fun addToDb(restaurantDetail: FetchRestaurantDetailResponse.Data.InternalData) {
        val favoriteModel = FavoriteModel(
            prefs.getString("phone", "") ?: ""
            ,
            restaurantDetail.id ?: "",
            restaurantDetail.name,
            restaurantDetail.rating,
            restaurantDetail.costForOne
            ,
            restaurantDetail.imageUrl
        )

        AddFavoriteAsyncTask(context, favoriteModel, "Add").execute()

    }

    private fun removeFromDb(restaurantDetail: FetchRestaurantDetailResponse.Data.InternalData) {
        val favoriteModel = FavoriteModel(
            prefs.getString("phone", "") ?: ""
            ,
            restaurantDetail.id ?: "",
            restaurantDetail.name,
            restaurantDetail.rating,
            restaurantDetail.costForOne
            ,
            restaurantDetail.imageUrl
        )

        AddFavoriteAsyncTask(context, favoriteModel, "Remove").execute()

    }


    inner class AddFavoriteAsyncTask(
        private var context: Context?,
        private var favoriteModel: FavoriteModel,
        private var param: String
    ) : AsyncTask<Void, Void, FavoriteModel>() {

        override fun onPostExecute(result: FavoriteModel?) {
            super.onPostExecute(result)
            if (result != null) {
                if (param == "Add")
                    Toast.makeText(context, "Added to favorite", Toast.LENGTH_SHORT).show()
                else if (param == "Remove")
                    Toast.makeText(context, "Removed from favorite", Toast.LENGTH_SHORT).show()
            }
        }

        override fun doInBackground(vararg url: Void): FavoriteModel {
            var c = 0
            try {
                if (param == "Add")
                    dao.addToFavorite(favoriteModel)
                else if (param == "Remove")
                    dao.removeFromFav(favoriteModel)


            } catch (e: SQLException) {
                Toast.makeText(context, "Error : $e", Toast.LENGTH_SHORT).show()
                c = 1
            }
            return if (c == 1)
                FavoriteModel("", "")
            else
                favoriteModel
        }
    }


    inner class GetFavoriteList(
        private var context: Context?
    ) : AsyncTask<Void, Void, List<FavoriteModel>>() {


        override fun onPostExecute(result: List<FavoriteModel>) {
            if (result.isNotEmpty()) {
                favoriteList = result
                favoriteList.forEach {
                    restaurantList.add(
                        FetchRestaurantDetailResponse.Data.InternalData(
                            it.id, it.name, it.rating, it.costForOne, it.imageUrl, true
                        )
                    )
                }
                rl_no_fav.visibility = View.GONE
                restaurantsAdapter.notifyDataSetChanged()
            } else
                rl_no_fav.visibility = View.VISIBLE


            super.onPostExecute(result)

        }

        override fun doInBackground(vararg url: Void): List<FavoriteModel> {
            var c = 0
            val favoriteRestaurantList: ArrayList<FavoriteModel> = ArrayList()
            try {
                dao.getFavoriteRestaurantList().forEach {
                    if (it.mobileNumber == prefs.getString("phone", ""))
                        favoriteRestaurantList.add(it)
                }

            } catch (e: SQLException) {
                Toast.makeText(context, "Error : $e", Toast.LENGTH_SHORT).show()
                c = 1
            }
            return if (c == 1)
                ArrayList()
            else
                favoriteRestaurantList
        }
    }

}



