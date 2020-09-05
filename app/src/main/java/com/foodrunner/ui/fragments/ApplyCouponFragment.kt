package com.foodrunner.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.foodrunner.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_apply_coupon.*


class ApplyCouponFragment(private val couponCallbackListener: CouponCallback, val appliedCoupon: Boolean, val couponName: String) : BottomSheetDialogFragment() {

    lateinit var couponCallback: CouponCallback

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_apply_coupon, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        couponCallback = couponCallbackListener

        when (couponName) {
            "MAX10" -> {
                tv_apply_10.text = context?.getString(R.string.remove)
                tvMax20.text = context?.getString(R.string.apply)
            }
            "MAX20" -> {
                tvMax20.text = context?.getString(R.string.remove)
                tv_apply_10.text = context?.getString(R.string.apply)
            }
            else -> {
                tv_apply_10.text = context?.getString(R.string.apply)
                tvMax20.text = context?.getString(R.string.apply)
            }
        }

        llTenOff.setOnClickListener{
            couponCallback.onApplyClick("MAX10",tv_apply_10.text.toString())
            if(tv_apply_10.text.toString() == "Remove"){
                tv_apply_10.text =context?.getString(R.string.apply)
            }
        }


        llTwentyOff.setOnClickListener{
            couponCallback.onApplyClick("MAX20", tvMax20.text.toString())
            if(tvMax20.text.toString() == "Remove"){
                tvMax20.text = context?.getString(R.string.apply)
            }
        }
    }

    interface CouponCallback{
        fun onApplyClick(couponName: String, status: String)
    }
}
