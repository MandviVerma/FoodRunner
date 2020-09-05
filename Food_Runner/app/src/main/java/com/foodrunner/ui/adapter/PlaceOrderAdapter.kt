package com.foodrunner.ui.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.foodrunner.R
import com.foodrunner.model.MenuModelResponse

class PlaceOrderAdapter(
    private var mContext: Context?,
    private var menu: ArrayList<MenuModelResponse.Data.MenuData>
) : RecyclerView.Adapter<PlaceOrderAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.selected_menu_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(menu[position],position)
    }


    fun refreshMyList(list: List<MenuModelResponse.Data.MenuData>) {
        menu.clear()
        menu.addAll(list)
        this.notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return menu.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val tvName = itemView.findViewById<TextView>(R.id.tv_food_name)
        private val tvPrice = itemView.findViewById<TextView>(R.id.tv_price)

        fun setData(
            details: MenuModelResponse.Data.MenuData,
            position: Int
        ) {

            tvName?.text = details.name
            tvPrice?.text = String.format((mContext?.getString(R.string.menu_price).toString()), details.costForOne)

        }
    }






}
