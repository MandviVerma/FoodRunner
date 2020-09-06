package com.foodrunner.ui.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.foodrunner.R
import com.foodrunner.api.FoodRunnerService
import com.foodrunner.db.AppDatabase
import com.foodrunner.db.RoomDao
import com.foodrunner.model.Food
import com.foodrunner.model.RestaurantDetailsResponse
import com.foodrunner.model.PlaceOrderModel
import com.foodrunner.model.CartResponse
import com.foodrunner.ui.adapter.CartMenuItemAdapter
import com.foodrunner.ui.fragments.ApplyCouponFragment
import com.foodrunner.utils.Constants.Companion.BASE_URL
import com.foodrunner.utils.Constants.Companion.FOOD_RUNNER
import com.foodrunner.utils.Constants.Companion.RESTAURANT_ID
import kotlinx.android.synthetic.main.activity_cart.*
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.sql.SQLException

class CartActivity : AppCompatActivity(), ApplyCouponFragment.CouponCallback {

    var restaurantId = ""
    var restaurantName = ""
    var restaurantImage=""
    var userId = ""
    var address= ""

    lateinit var cartMenuItemAdapter: CartMenuItemAdapter
    var cart: ArrayList<RestaurantDetailsResponse.Data.MenuData> = ArrayList()
    var totalCost = 0
    var price : Double? =null
    var foodList: ArrayList<Food> = ArrayList()
    lateinit var applyCouponFragment : ApplyCouponFragment
    private var couponApplied =false
    private var nameCoupon :String = ""
    lateinit var httpClient: OkHttpClient.Builder
    lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        supportActionBar?.hide()

        val prefs: SharedPreferences = getSharedPreferences(FOOD_RUNNER, Context.MODE_PRIVATE)!!

        httpClient = OkHttpClient.Builder()
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        restaurantId = intent.getStringExtra(RESTAURANT_ID) ?: ""
        restaurantName = intent.getStringExtra("restaurantName") ?: ""
        restaurantImage = intent.getStringExtra("imageUrl") ?: ""
        userId = prefs.getString("userId", "") ?: ""
        address = prefs.getString("address","")?:""

        tv_apply_coupon.text = getString(R.string.apply_coupon)
        tv_address_name.text=address
        tv_restaurant_name.text =restaurantName
        Glide.with(this).load(restaurantImage).apply(RequestOptions.centerCropTransform()).into(ivRestaurant)

        initRecyclerView()
        getCart()

        initClicks()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id=item.itemId
        if(id==android.R.id.home) {
           super.onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initClicks() {
        btn_place_order.setOnClickListener {
            if (foodList.isNotEmpty()) {
                val placeOrderModel = PlaceOrderModel(userId, restaurantId, totalCost.toString(),foodList)
                placeOrder(placeOrderModel)
            }
            else
                Toast.makeText(this,"Something went wrong",Toast.LENGTH_SHORT).show()
        }

        cv_coupon.setOnClickListener{

            applyCouponFragment = ApplyCouponFragment(this, couponApplied, nameCoupon)
            applyCouponFragment.show(supportFragmentManager, "coupon")

        }


    }


    private fun initRecyclerView() {
        cartMenuItemAdapter = cart.let {
            CartMenuItemAdapter(this, it) }

        rv_menu.apply {
            adapter = cartMenuItemAdapter
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }
    }


    private fun getCart() {
        GetCartAsynTask(this).execute()
    }


    inner class GetCartAsynTask(
        private var context: Context?
    ) : AsyncTask<Void, Void, List<RestaurantDetailsResponse.Data.MenuData>>() {

        var dao: RoomDao = AppDatabase.getInstance(context!!).RoomDao()


        override fun onPostExecute(result: List<RestaurantDetailsResponse.Data.MenuData>) {
            if (result.isNotEmpty()) {
                cart = result as ArrayList<RestaurantDetailsResponse.Data.MenuData>
                cartMenuItemAdapter.refreshMyList(cart)

                cart.forEach {
                    totalCost += it.costForOne?.toInt() ?: 0
                    foodList.add(Food(it.id))
                }

                price = totalCost.toDouble()
                btn_place_order.text = String.format((getString(R.string.place_order)), totalCost)

            }
            super.onPostExecute(result)

        }

        override fun doInBackground(vararg url: Void): List<RestaurantDetailsResponse.Data.MenuData> {
            var c = 0
            var cart: List<RestaurantDetailsResponse.Data.MenuData> = ArrayList()
            try {
                cart = dao.getCart()
            } catch (e: SQLException) {
                Toast.makeText(context, "Error : $e", Toast.LENGTH_SHORT).show()
                c = 1
            }
            return if (c == 1)
                ArrayList()
            else
                cart
        }
    }

    private fun placeOrder(placeOrderModel: PlaceOrderModel) {
        val api = retrofit.create(FoodRunnerService::class.java)

        val call = api.placeOrder(placeOrderModel)

        call.enqueue(object : Callback<CartResponse> {
            override fun onFailure(call: Call<CartResponse>, t: Throwable) {
                 Log.i("on fail", t.toString())
            }

            override fun onResponse(
                call: Call<CartResponse>,
                response: retrofit2.Response<CartResponse>
            ) {
                Log.i("onresponse",response.body().toString())
                if(response.body()?.data?.success== true){
                    startActivity(Intent(this@CartActivity, OrderPlacedActivity::class.java))
                    finish()
                }

            }
        })


    }

    override fun onApplyClick(couponName: String, status: String) {
        if(couponName =="MAX10"){
            if(totalCost>149) {
                if (status == getString(R.string.apply)){
                    val newPrice = totalCost - (totalCost * 0.1)
                    btn_place_order.text = String.format((getString(R.string.place_order)), newPrice)
                    tv_apply_coupon.text = couponName
                    this.nameCoupon = couponName
                    applyCouponFragment.dismiss()
                }else {
                    Toast.makeText(this, "Removed", Toast.LENGTH_SHORT).show()
                    btn_place_order.text = String.format((getString(R.string.place_order)), totalCost)
                    tv_apply_coupon.text = getString(R.string.apply_coupon)
                    this.nameCoupon =""
                }
            }
            else{
                Toast.makeText(this,"Total cost is not enough",Toast.LENGTH_SHORT).show()
            }
        }else{
            if(totalCost>399) {

                if (status == getString(R.string.apply)){
                    val newPrice = totalCost - (totalCost * 0.2)
                    btn_place_order.text = String.format((getString(R.string.place_order)), newPrice)
                    tv_apply_coupon.text = couponName
                    this.nameCoupon = couponName
                    applyCouponFragment.dismiss()
                }else {
                    Toast.makeText(this, "Removed", Toast.LENGTH_SHORT).show()
                    btn_place_order.text = String.format((getString(R.string.place_order)), totalCost)
                    tv_apply_coupon.text = getString(R.string.apply_coupon)
                    this.nameCoupon =""
                }
            }
            else{
                Toast.makeText(this,"Total cost is not enough",Toast.LENGTH_SHORT).show()
            }
        }
    }


}
