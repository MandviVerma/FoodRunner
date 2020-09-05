package com.foodrunner.ui.adapter

import com.foodrunner.model.OrderHistoryModelResponse
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.foodrunner.R

class OrderHistoryMenuItemAdapter(
    private var mContext: Context?,
    private var menu: ArrayList<OrderHistoryModelResponse.Data.Orders.FoodItems>
) : RecyclerView.Adapter<OrderHistoryMenuItemAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_menu_selected, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(menu[position],position)
    }

    override fun getItemCount(): Int {
        return menu.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val tvName = itemView.findViewById<TextView>(R.id.tv_food_name)
        private val tvPrice = itemView.findViewById<TextView>(R.id.tv_price)

        fun setData(
            details: OrderHistoryModelResponse.Data.Orders.FoodItems,
            position: Int
        ) {

            tvName?.text = details.foodName
            tvPrice?.text = String.format((mContext?.getString(R.string.menu_price).toString()), details.foodCost)

        }
    }


}
