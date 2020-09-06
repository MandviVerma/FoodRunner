package com.foodrunner.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.foodrunner.R
import com.foodrunner.model.RestaurantDetailsResponse

class RestaurantDetailsAdapter(
    private var mContext: Context?,
    private var restaurantDetails: ArrayList<RestaurantDetailsResponse.Data.MenuData>,
    private var mListener: OnItemClickListener
) : RecyclerView.Adapter<RestaurantDetailsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_restaurant_menu, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(restaurantDetails[position], position)

    }

    override fun getItemCount(): Int {
        return restaurantDetails.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val tvName = itemView.findViewById<TextView>(R.id.tv_menu_name)
        private val tvMenuId = itemView.findViewById<TextView>(R.id.tv_menu_id)
        private val tvPrice = itemView.findViewById<TextView>(R.id.tv_price)
        private val addBtn = itemView.findViewById<Button>(R.id.btn_add)


        fun setData(
            details: RestaurantDetailsResponse.Data.MenuData,
            position: Int
        ) {

            tvName?.text = details.name
            tvMenuId?.text = details.id
            tvPrice?.text = String.format(
                (mContext?.getString(R.string.menu_price).toString()),
                details.costForOne
            )

            addBtn.setOnClickListener {
                mListener.onItemClick(position, it)
            }
        }
    }


    interface OnItemClickListener {
        fun onItemClick(position: Int, view: View)

    }

}
