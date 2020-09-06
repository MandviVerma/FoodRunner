package com.foodrunner.ui.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.foodrunner.R
import com.foodrunner.model.FetchRestaurantDetailResponse


class RestaurantsAdapter(
    private var mContext: Context?,
    private var restaurants: ArrayList<FetchRestaurantDetailResponse.Data.InternalData>,
    private var mListener: OnItemClickListener
) : RecyclerView.Adapter<RestaurantsAdapter.ViewHolder>() , Filterable {

    private var filteredRestaurants  = restaurants


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_home, parent, false)
        return ViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(filteredRestaurants[position],position)
        holder.itemView.setOnClickListener {
            mListener.onItemClick(position,it)
        }
    }

    override fun getItemCount(): Int {
        return filteredRestaurants.size
    }



    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val tvName = itemView.findViewById<TextView>(R.id.tv_restaurant)
        private val tvRate = itemView.findViewById<TextView>(R.id.tv_rate)
        private val tvRating = itemView.findViewById<TextView>(R.id.tv_rating)
        private val ivRestaurantImg = itemView.findViewById<ImageView>(R.id.iv_restaurant)
        private val ivFav = itemView.findViewById<ImageView>(R.id.iv_fav)
        private val ivShare = itemView.findViewById<ImageView>(R.id.iv_share)

        fun setData(
            details: FetchRestaurantDetailResponse.Data.InternalData,
            position: Int
        ) {

            tvName?.text = details.name
            tvRate?.text = String.format((mContext?.getString(R.string.rate).toString()), details.costForOne)
            if(details.rating?.toDouble()!!>=4.0){
                tvRating.setTextColor(Color.parseColor("#7BC242"))
            }
            else{
                tvRating.setTextColor(Color.parseColor("#ff0000"))

            }
            tvRating?.text = details.rating
            Glide.with(mContext!!).load(details.imageUrl).apply(RequestOptions.centerCropTransform()).into(ivRestaurantImg)

            if(details.isFav != null) {
                if (details.isFav!!)
                    ivFav.setImageResource(R.drawable.ic_fill_fav)
                else if (!details.isFav!!)
                    ivFav.setImageResource(R.drawable.ic_not_fav)
            }else
                ivFav.setImageResource(R.drawable.ic_not_fav)


            ivFav.setOnClickListener{
                mListener.onFavClick(position,it)
            }
            ivShare.setOnClickListener{
                mListener.onShareClick(position,it)
            }
        }
    }


    override fun getFilter(): Filter {

        return object : Filter() {
            override fun performFiltering(charSequence: CharSequence): FilterResults {
                val charString = charSequence.toString()
                filteredRestaurants = if (charString.isEmpty()) {
                    restaurants
                } else {
                    val filteredList = ArrayList<FetchRestaurantDetailResponse.Data.InternalData>()
                    for (restaurant in restaurants) {

                        if (restaurant.name!!.toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(restaurant)
                        }
                    }

                    filteredList
                }

                val filterResults = FilterResults()
                filterResults.values = filteredRestaurants
                return filterResults
            }

            override fun publishResults(charSequence: CharSequence, filterResults: FilterResults) {
                filteredRestaurants = filterResults.values as ArrayList<FetchRestaurantDetailResponse.Data.InternalData>
                notifyDataSetChanged()
            }
        }
    }
    interface OnItemClickListener {
        fun onItemClick(position: Int, view: View)
        fun onFavClick(position: Int, view: View)
        fun onShareClick(position: Int, view: View)

    }

}
