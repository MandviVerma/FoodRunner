package com.foodrunner.ui.auth

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.foodrunner.R
import com.foodrunner.api.FoodRunnerService
import com.foodrunner.db.AppDatabase
import com.foodrunner.db.RoomDao
import com.foodrunner.model.*
import kotlinx.android.synthetic.main.activity_forgot_password.*
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ForgotPasswordActivity : AppCompatActivity() {


    lateinit var dao: RoomDao
    lateinit var prefs: SharedPreferences
    var BASE_URL = "http://13.235.250.119/"
    lateinit var httpClient: OkHttpClient.Builder
    lateinit var retrofit: Retrofit


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        supportActionBar?.hide()

        dao = AppDatabase.getInstance(this).RoomDao()
        prefs = getSharedPreferences("Food Runner", Context.MODE_PRIVATE)


        httpClient = OkHttpClient.Builder()
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        btn_next.setOnClickListener {
            startActivity(Intent(this, ResetPasswordActivity::class.java))
            if (validate()) {
                checkUserIsRegistered(et_mobile_number.text.toString(), et_email.text.toString())
            } else
                Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show()
        }

    }


    private fun validate(): Boolean {

        return et_mobile_number.text.toString() != " "
                && et_mobile_number.text.toString().length == 10
                && et_email.text.toString().contains("@")
                && et_email.text.toString().contains(".com")

    }

    private fun checkUserIsRegistered(phone: String, email: String) {

        val api = retrofit.create(FoodRunnerService::class.java)

        val forgotPasswordModel = ForgotPasswordModel(phone, email)
        val call = api.forgotPassword(forgotPasswordModel)

        call.enqueue(object : Callback<ForgotPasswordResponse> {
            override fun onFailure(call: Call<ForgotPasswordResponse>, t: Throwable) {
                //Toast.makeText(this ,"On failure",Toast.LENGTH_SHORT).show()
                Log.i("h", "on fail" + t.toString())
            }

            override fun onResponse(
                call: Call<ForgotPasswordResponse>,
                response: retrofit2.Response<ForgotPasswordResponse>
            ) {
                Log.i("d", response.body().toString())
                if (response.body()?.data?.success != null) {
                    if (response.body()?.data?.success!!) {

                        val intent = Intent(this@ForgotPasswordActivity,
                            ResetPasswordActivity::class.java)
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                        intent.putExtra("mobileNumber",phone)
                        startActivity(intent)
                    } else
                        Toast.makeText(
                            this@ForgotPasswordActivity,
                            "Otp success Failed" ,
                            Toast.LENGTH_SHORT
                        ).show()


                } else {
                    Toast.makeText(
                        this@ForgotPasswordActivity,
                        "Response Failed" ,
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }


        })

    }
}


