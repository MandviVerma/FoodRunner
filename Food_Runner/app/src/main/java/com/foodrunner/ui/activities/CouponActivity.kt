package com.foodrunner.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.foodrunner.R
import kotlinx.android.synthetic.main.activity_coupon.*

class CouponActivity : AppCompatActivity() {

    var couponName =  ""
    var price =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coupon)

        price = intent.getIntExtra("ORDER_VALUE", 0)
        couponName = intent.getStringExtra("COUPON_NAME")?:""

        if (couponName == "Coupon Applied 10% off") {
            tv_apply_10.text = "Remove"
            tv_apply_20.text = "Apply"

        } else if (couponName == "Coupon Applied 20% off") {
            tv_apply_20.text = "Remove"
            tv_apply_10.text = "Apply"

        }
        else {
            tv_apply_10.text = "Apply"
            tv_apply_20.text = "Apply"
        }

        supportActionBar?.title = "Coupons"

        ll_ten_off.setOnClickListener{

            if(price>200) {
                val intent = Intent(this@CouponActivity, CartActivity::class.java)

                if (tv_apply_10.text == "Apply"){
                    val newPrice = price - (price * 0.1)
                    intent.putExtra("NEW_ORDER_VALUE", newPrice)
                    intent.putExtra("COUPON_NAME", "Coupon Applied 10% off")
                }else {
                    Toast.makeText(this, "Removed", Toast.LENGTH_SHORT).show()
                    intent.putExtra("NEW_ORDER_VALUE", price)
                    intent.putExtra("COUPON_NAME", "")
                }
                setResult(100, intent)
                finish()
            }
            else{
                Toast.makeText(this,"Order Value is not sufficient",Toast.LENGTH_SHORT).show()
            }
        }


        ll_twenty_off.setOnClickListener{
            if(price>500) {

                val intent = Intent(this@CouponActivity, CartActivity::class.java)

                if (tv_apply_20.text == "Apply"){
                    val newPrice = price - (price * 0.2)
                    intent.putExtra("NEW_ORDER_VALUE", newPrice)
                    intent.putExtra("COUPON_NAME", "Coupon Applied 20% off")
                }else {
                    Toast.makeText(this, "Removed", Toast.LENGTH_SHORT).show()
                    intent.putExtra("NEW_ORDER_VALUE", price)
                    intent.putExtra("COUPON_NAME", "")
                }
                setResult(100, intent)
                finish()
            }
            else{
                Toast.makeText(this,"Order Value is not sufficient",Toast.LENGTH_SHORT).show()
            }
        }
    }


}
