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
            ll_chat_white_box.visibility=View.GONE
            ll_q1.visibility=View.VISIBLE
        }
        q11.setOnClickListener {
            ll_q11_ans.visibility=View.VISIBLE
            ll_q11.visibility=View.VISIBLE
            q11.visibility=View.GONE

        }
        q12.setOnClickListener {
            ll_q12_ans.visibility=View.VISIBLE
            ll_q12.visibility=View.VISIBLE
            q11.visibility=View.GONE


        }
        q111.setOnClickListener {
            ll_q111_ans.visibility=View.VISIBLE
            contact_ans.visibility=View.VISIBLE
            q111.visibility=View.GONE

        }
        q112.setOnClickListener {
            ll_q112_ans.visibility=View.VISIBLE
            just_ans.visibility=View.VISIBLE
            q111.visibility=View.GONE

        }
        q121.setOnClickListener {
            ll_q121_ans.visibility=View.VISIBLE
            food_ans.visibility=View.VISIBLE
            q121.visibility=View.GONE

        }
        q122.setOnClickListener {
            ll_q122_ans.visibility=View.VISIBLE
            spillage_ans.visibility=View.VISIBLE
            q121.visibility=View.GONE

        }
    }
}