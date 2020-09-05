package com.foodrunner.ui.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.foodrunner.R
import com.foodrunner.model.RestaurantDetailsResponse

class CartMenuItemAdapter(
    private var mContext: Context?,
    private var restaurantDetails: ArrayList<RestaurantDetailsResponse.Data.MenuData>
) : RecyclerView.Adapter<CartMenuItemAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_menu_selected, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(restaurantDetails[position],position)
    }


    fun refreshMyList(list: List<RestaurantDetailsResponse.Data.MenuData>) {
        restaurantDetails.clear()
        restaurantDetails.addAll(list)
        this.notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return restaurantDetails.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val tvName = itemView.findViewById<TextView>(R.id.tv_food_name)
        private val tvPrice = itemView.findViewById<TextView>(R.id.tv_price)

        fun setData(
            details: RestaurantDetailsResponse.Data.MenuData,
            position: Int
        ) {

            tvName?.text = details.name
            tvPrice?.text = String.format((mContext?.getString(R.string.menu_price).toString()), details.costForOne)

        }
    }






}
