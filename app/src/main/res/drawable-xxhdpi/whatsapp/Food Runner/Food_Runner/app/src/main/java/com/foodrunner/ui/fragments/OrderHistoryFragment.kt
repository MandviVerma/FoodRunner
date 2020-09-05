package com.foodrunner.ui.fragments

import android.content.Context
import android.content.SharedPreferences
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.foodrunner.R
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.foodrunner.api.FoodRunnerService
import com.foodrunner.model.PastOrdersModelResponse
import com.foodrunner.ui.adapter.OrderHistoryAdapter
import kotlinx.android.synthetic.main.fragment_order_history.*
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.collections.ArrayList

class OrderHistoryFragment : Fragment() {
    lateinit var pastOrdersAdapter: OrderHistoryAdapter
    val ordersList = ArrayList<PastOrdersModelResponse.Data.Orders>()

    lateinit var prefs: SharedPreferences
    var BASE_URL = "http://13.235.250.119/"
    lateinit var httpClient: OkHttpClient.Builder
    lateinit var retrofit: Retrofit


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_order_history, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        prefs = activity?.getSharedPreferences("Food Runner", Context.MODE_PRIVATE)!!

        val userId = prefs.getString("userId","")?:""

        setHasOptionsMenu(false)

        httpClient = OkHttpClient.Builder()
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        getOrders(userId)

        pastOrdersAdapter = ordersList.let {
            OrderHistoryAdapter(context, it, object : OrderHistoryAdapter.OnItemClickListener {
                override fun onItemClick(position: Int, view: View) {

                }
            })
        }
        rv_past_orders.apply {
            adapter = pastOrdersAdapter
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }
    }

    private fun getOrders(userId: String) {

        val  api= retrofit.create(FoodRunnerService::class.java)

        val call =api.getPastOrders(userId)

        call.enqueue(object : Callback<PastOrdersModelResponse> {
            override fun onFailure(call: Call<PastOrdersModelResponse>, t: Throwable) {
                //Toast.makeText(this ,"On failure",Toast.LENGTH_SHORT).show()
                Log.i("h","on fail"+t.toString())
            }

            override fun onResponse(
                call: Call<PastOrdersModelResponse>,
                response: retrofit2.Response<PastOrdersModelResponse>
            ) {
                Log.i("d",response.body().toString())
                response.body()?.data?.data?.forEach {
                    ordersList.add(it!!)
                }
                if(ordersList.isEmpty())
                    rl_no_order.visibility=View.VISIBLE
                else
                    rl_no_order.visibility=View.GONE

                pastOrdersAdapter.notifyDataSetChanged()

            }
        })
    }


}



