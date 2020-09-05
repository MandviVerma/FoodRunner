package com.foodrunner.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.foodrunner.R
import kotlinx.android.synthetic.main.activity_order_placed.*

class OrderPlacedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_placed)

        supportActionBar?.hide()


        btn_ok.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags( Intent.FLAG_ACTIVITY_NEW_TASK )
            intent.addFlags( Intent.FLAG_ACTIVITY_CLEAR_TOP )
            intent.addFlags( Intent.FLAG_ACTIVITY_CLEAR_TASK )
            startActivity(intent)
            finish()
        }
    }

    override fun onBackPressed() {
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags( Intent.FLAG_ACTIVITY_NEW_TASK )
        intent.addFlags( Intent.FLAG_ACTIVITY_CLEAR_TOP )
        intent.addFlags( Intent.FLAG_ACTIVITY_CLEAR_TASK )
        startActivity(intent)
        finish()
    }
}
