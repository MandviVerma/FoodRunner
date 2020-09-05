package com.foodrunner.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.foodrunner.R
import kotlinx.android.synthetic.main.activity_cart.*
import kotlinx.android.synthetic.main.activity_chat.*

class ChatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        var restaurantName = ""
        restaurantName = intent.getStringExtra("restaurant_name") ?: ""
        ques_rest_name.text = restaurantName
        ans_rest_name.text = String.format(getString(R.string.order_from_s), restaurantName)

        ll_chat.setOnClickListener {
            ans.visibility = View.VISIBLE
            q1.visibility=View.VISIBLE
        }
        q11.setOnClickListener {
            ll_q11_ans.visibility=View.VISIBLE
        }
        q12.setOnClickListener {
            ll_q12_ans.visibility=View.VISIBLE

        }
    }
}