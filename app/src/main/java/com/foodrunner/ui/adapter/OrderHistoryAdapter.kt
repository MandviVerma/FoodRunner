package com.foodrunner.ui.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.foodrunner.R
import com.foodrunner.model.OrderHistoryModelResponse

@Suppress("UNCHECKED_CAST")
class OrderHistoryAdapter(
    private var mContext: Context?,
    private var orders: ArrayList<OrderHistoryModelResponse.Data.Orders>,
    private var mListener: OnItemClickListener
) : RecyclerView.Adapter<OrderHistoryAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_order_history, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(orders[position],position)

    }

    override fun getItemCount(): Int {
        return orders.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val tvRestaurantName = itemView.findViewById<TextView>(R.id.tv_restaurant_name)
        private val tvDate = itemView.findViewById<TextView>(R.id.tv_Date)
        private val tvTotalPrice = itemView.findViewById<TextView>(R.id.tv_total_cost)
        private val rvFoodItems = itemView.findViewById<RecyclerView>(R.id.rv_order_items)
        private val tvChat = itemView.findViewById<TextView>(R.id.tvChat)




        fun setData(
            details: OrderHistoryModelResponse.Data.Orders,
            position: Int
        ) {

            tvRestaurantName?.text = details.restaurantName
            tvDate?.text = details.orderPlacedAt
            tvTotalPrice?.text = String.format((mContext?.getString(R.string.total_cost_s).toString()), details.totalCost)

            val orderHistoryMenuItemAdapter: OrderHistoryMenuItemAdapter
            orderHistoryMenuItemAdapter = details.foodItems.let { it ->
                OrderHistoryMenuItemAdapter(mContext,
                    it as ArrayList<OrderHistoryModelResponse.Data.Orders.FoodItems>) }
            rvFoodItems.apply {
                adapter = orderHistoryMenuItemAdapter
                layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            }
            tvChat.setOnClickListener{
                mListener.onChatClick(position,it)
            }
        }
    }




    interface OnItemClickListener {
        fun onItemClick(position: Int, view: View)
        fun onChatClick(position: Int, view: View)


    }

}
