package com.foodrunner.ui.auth

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import com.foodrunner.R
import com.foodrunner.api.FoodRunnerService
import com.foodrunner.db.AppDatabase
import com.foodrunner.db.RoomDao
import com.foodrunner.model.ResetPasswordModel
import com.foodrunner.model.ResetPasswordResponse
import kotlinx.android.synthetic.main.activity_reset_password.*
import kotlinx.android.synthetic.main.activity_reset_password.et_password
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ResetPasswordActivity : AppCompatActivity(), TextWatcher {


    var mobileNumber :String =""
    lateinit var dao: RoomDao
    lateinit var prefs: SharedPreferences
    var BASE_URL = "http://13.235.250.119/"
    lateinit var httpClient: OkHttpClient.Builder
    lateinit var retrofit: Retrofit

    override fun afterTextChanged(editable: Editable?) {
        if (editable?.length == 1) {
            if (etOne.length() == 1) {
                etTwo.requestFocus()
            }
            if (etTwo.length() == 1) {
                etThree.requestFocus()
            }
            if (etThree.length() == 1) {
                etFour.requestFocus()
            }
        } else if (editable?.length == 0) {
            if (etFour.length() == 0) {
                etThree.requestFocus()
            }
            if (etThree.length() == 0) {
                etTwo.requestFocus()
            }
            if (etTwo.length() == 0) {
                etOne.requestFocus()
            }
        }
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)


        dao = AppDatabase.getInstance(this).RoomDao()
        prefs = getSharedPreferences("Food Runner", Context.MODE_PRIVATE)


        httpClient = OkHttpClient.Builder()
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        mobileNumber = intent.getStringExtra("mobileNumber")?:""
        etOne.addTextChangedListener(this)
        etTwo.addTextChangedListener(this)
        etThree.addTextChangedListener(this)
        etFour.addTextChangedListener(this)
        supportActionBar?.hide()


        btn_submit.setOnClickListener {
            val editTextOne=etOne.text.toString()
            val editTextTwo=etTwo.text.toString()
            val editTextThree=etThree.text.toString()
            val editTextFour=etFour.text.toString()

            val otp=""+editTextOne+editTextTwo+editTextThree+editTextFour

            if (check() && otp.length ==4) {
                checkUserIsRegistered(mobileNumber, et_password.text.toString(),otp)
            } else
                Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show()
        }

    }


    private fun check(): Boolean {
        return et_password.text.toString()!=""
                && et_password.text.toString()==et_confirm_password.text.toString()
                &&et_password.text.toString().length>=4
    }


    private fun checkUserIsRegistered(
        phone: String,
        password: String,
        otp:String
    ) {

        val api = retrofit.create(FoodRunnerService::class.java)

        val resetPasswordModel = ResetPasswordModel(phone,password,otp)
        val call = api.resetPassword(resetPasswordModel)

        call.enqueue(object : Callback<ResetPasswordResponse> {
            override fun onFailure(call: Call<ResetPasswordResponse>, t: Throwable) {
                //Toast.makeText(this ,"On failure",Toast.LENGTH_SHORT).show()
                Log.i("h", "on fail" + t.toString())
            }

            override fun onResponse(
                call: Call<ResetPasswordResponse>,
                response: retrofit2.Response<ResetPasswordResponse>
            ) {
                Log.i("d", response.body().toString())
                if (response.body()?.data?.success != null) {
                    if (response.body()?.data?.success!!) {

                        val intent = Intent(this@ResetPasswordActivity,LoginActivity::class.java)
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                        startActivity(intent)
                        finish()
                    } else
                        Toast.makeText(
                            this@ResetPasswordActivity,
                            "Otp success Failed" ,
                            Toast.LENGTH_SHORT
                        ).show()


                } else {
                    Toast.makeText(
                        this@ResetPasswordActivity,
                        "Response Failed" ,
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }


        })

    }
}

