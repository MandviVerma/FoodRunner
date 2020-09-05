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
import com.foodrunner.R
import com.foodrunner.api.FoodRunnerService
import com.foodrunner.db.AppDatabase
import com.foodrunner.db.RoomDao
import com.foodrunner.model.Food
import com.foodrunner.model.MenuModelResponse
import com.foodrunner.model.PlaceOrderModel
import com.foodrunner.model.PlaceOrderResponse
import com.foodrunner.ui.adapter.PlaceOrderAdapter
import kotlinx.android.synthetic.main.activity_place_order.*
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.sql.SQLException

class CartActivity : AppCompatActivity() {

    var restaurantId = ""
    var restaurantName = ""
    var userId = ""
    var address= ""

    lateinit var placeOrderAdapter: PlaceOrderAdapter
    var cart: ArrayList<MenuModelResponse.Data.MenuData> = ArrayList()
    var totalCost = 0
    var price : Double? =null
    var foodList: ArrayList<Food> = ArrayList()

    var BASE_URL = "http://13.235.250.119/"
    lateinit var httpClient: OkHttpClient.Builder
    lateinit var retrofit: Retrofit


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place_order)
        supportActionBar?.hide()


        val prefs: SharedPreferences = getSharedPreferences("Food Runner", Context.MODE_PRIVATE)!!

        httpClient = OkHttpClient.Builder()
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()



        restaurantId = intent.getStringExtra("restaurantId") ?: ""
        restaurantName = intent.getStringExtra("restaurantName") ?: ""
        userId = prefs.getString("userId", "") ?: ""
        address = prefs.getString("address","")?:""

        tv_apply_coupon.text = "Apply Coupon"

        tv_address_name.text=address

        tv_restaurant_name.text =
            String.format(getString(R.string.ordering_from_s), restaurantName)
        initRecyclerView()
        getCart()

        initClicks()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id=item.itemId
        if(id==android.R.id.home)
        {
           super.onBackPressed()
        }

        return super.onOptionsItemSelected(item)
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)


        if(requestCode == 100){

                price = data?.getDoubleExtra("NEW_ORDER_VALUE", 0.0)
                var couponName = data?.getStringExtra("COUPON_NAME")

                if(price == 0.0 || price == null)
                    price = totalCost.toDouble()

                if(couponName == "" || couponName ==null)
                    couponName = "Apply Coupon"

                btn_place_order.text = String.format((getString(R.string.place_order)), price)
                tv_apply_coupon.text = couponName
            }

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
            val intent = Intent(this@CartActivity,
                CouponActivity::class.java)

            when {
                tv_apply_coupon.text == "Coupon Applied 10% off" -> intent.putExtra("COUPON_NAME","Coupon Applied 10% off")
                tv_apply_coupon.text == "Coupon Applied 20% off" -> intent.putExtra("COUPON_NAME","Coupon Applied 20% off")
                else -> intent.putExtra("COUPON_NAME","Not Applied")
            }



            intent.putExtra("ORDER_VALUE",totalCost)
            startActivityForResult(intent,100)


        }


    }


    private fun initRecyclerView() {
        placeOrderAdapter = cart.let {
            PlaceOrderAdapter(this, it) }

        rv_menu.apply {
            adapter = placeOrderAdapter
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }
    }


    private fun getCart() {
        GetCartAsynTask(this).execute()
    }


    inner class GetCartAsynTask(
        private var context: Context?
    ) : AsyncTask<Void, Void, List<MenuModelResponse.Data.MenuData>>() {

        var dao: RoomDao = AppDatabase.getInstance(context!!).RoomDao()


        override fun onPostExecute(result: List<MenuModelResponse.Data.MenuData>) {
            if (result.isNotEmpty()) {
                cart = result as ArrayList<MenuModelResponse.Data.MenuData>
                placeOrderAdapter.refreshMyList(cart)

                cart.forEach {
                    totalCost += it.costForOne?.toInt() ?: 0
                    foodList.add(Food(it.id))
                }

                price = totalCost.toDouble()
                btn_place_order.text = String.format((getString(R.string.place_order)), totalCost)

            }
            super.onPostExecute(result)

        }

        override fun doInBackground(vararg url: Void): List<MenuModelResponse.Data.MenuData> {
            var c = 0
            var cart: List<MenuModelResponse.Data.MenuData> = ArrayList()
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

        call.enqueue(object : Callback<PlaceOrderResponse> {
            override fun onFailure(call: Call<PlaceOrderResponse>, t: Throwable) {
                 Log.i("on fail", t.toString())
            }

            override fun onResponse(
                call: Call<PlaceOrderResponse>,
                response: retrofit2.Response<PlaceOrderResponse>
            ) {
                Log.i("onresponse",response.body().toString())
                if(response.body()?.data?.success== true){
                    startActivity(Intent(this@CartActivity, OrderPlacedActivity::class.java))
                    finish()
                }

            }
        })

    }


}
