package com.foodrunner.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import com.foodrunner.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.filter.*

class SortFilterFragment(private val filterListener: FilterInterface) : BottomSheetDialogFragment() {

    companion object {
        var priceFirst = false
        var priceSecond = false
        var priceThird = false
        var ratingFirst = false
        var ratingSecond = false
        var ratingThird = false
        var cost = false
        var rating = false
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.filter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        below200.isChecked = priceFirst
        between200300.isChecked = priceSecond
        between300500.isChecked = priceThird
        star4.isChecked = ratingFirst
        star3.isChecked = ratingSecond
        star2.isChecked = ratingThird
        rbCost.isChecked = cost
        rbRating.isChecked = rating

        tvSort.setOnClickListener {
            llFilter.visibility =GONE
            llSort.visibility = VISIBLE
        }

        tvFilter.setOnClickListener {
            llFilter.visibility = VISIBLE
            llSort.visibility = GONE
        }

        tvApplyFilter.setOnClickListener {
            priceFirst = below200.isChecked
            priceSecond = between200300.isChecked
            priceThird = between300500.isChecked
            ratingFirst = star4.isChecked
            ratingSecond = star3.isChecked
            ratingThird = star2.isChecked
            cost = rbCost.isChecked
            rating = rbRating.isChecked
            filterListener.OnApplyClick(priceFirst, priceSecond, priceThird, ratingFirst, ratingSecond, ratingThird,cost, rating)
        }

        tvClearAll.setOnClickListener {
            priceFirst = false
            priceSecond = false
            priceThird = false
            ratingFirst = false
            ratingSecond = false
            ratingThird = false

            below200.isChecked = priceFirst
            between200300.isChecked = priceSecond
            between300500.isChecked = priceThird
            star4.isChecked = ratingFirst
            star3.isChecked = ratingSecond
            star2.isChecked = ratingThird
        }
    }


}

interface FilterInterface {
    fun OnApplyClick(
        price1: Boolean,
        price2: Boolean,
        price3: Boolean,
        rating1: Boolean,
        rating2: Boolean,
        rating3: Boolean,
        cost: Boolean,
        rating: Boolean
    )
}



