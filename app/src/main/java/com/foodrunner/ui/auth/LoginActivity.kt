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
import com.foodrunner.model.AuthModelResponse
import com.foodrunner.model.LoginModel
import com.foodrunner.ui.activities.MainActivity
import kotlinx.android.synthetic.main.activity_login.*
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginActivity : AppCompatActivity() {


        lateinit var dao: RoomDao
        lateinit var prefs: SharedPreferences
        var BASE_URL = "http://13.235.250.119/"
        lateinit var httpClient: OkHttpClient.Builder
        lateinit var retrofit: Retrofit


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.hide()
        dao = AppDatabase.getInstance(this).RoomDao()
        prefs = getSharedPreferences("Food Runner", Context.MODE_PRIVATE)

        if (prefs.getString("name", "") != "") {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }


        httpClient = OkHttpClient.Builder()
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()



        btnLogin.setOnClickListener {
            if (check()) {
                checkUserIsRegistered(et_mobile_number.text.toString(), et_password.text.toString())
            } else
                Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show()
        }
        tvSignUp.setOnClickListener {
            startActivity(Intent(this, RegistrationActivity::class.java))
        }
        tvFP.setOnClickListener {
            startActivity(Intent(this, ForgotPasswordActivity::class.java))
        }

    }




    private fun check(): Boolean {

        return et_mobile_number.text.toString() !=" "
                && et_password.text.toString().length>=4
                && et_password.text.toString() !=" "
                && et_mobile_number.text.toString().length == 10

    }



    private fun checkUserIsRegistered(phone: String, password: String) {

        val api = retrofit.create(FoodRunnerService::class.java)

        val loginModel = LoginModel(phone, password)
        val call = api.loginUser(loginModel)

        call.enqueue(object : Callback<AuthModelResponse> {
            override fun onFailure(call: Call<AuthModelResponse>, t: Throwable) {
                //Toast.makeText(this ,"On failure",Toast.LENGTH_SHORT).show()
                Log.i("h", "on fail" + t.toString())
            }

            override fun onResponse(
                call: Call<AuthModelResponse>,
                response: retrofit2.Response<AuthModelResponse>
            ) {
                Log.i("d", response.body().toString())
                if (response.body()?.data?.success != null) {
                    if (response.body()?.data?.success!!) {
                        val editor = prefs.edit()
                        editor.putString("userId", response.body()?.data?.data?.userId)
                        editor.putString("name", response.body()?.data?.data?.name)
                        editor.putString("address", response.body()?.data?.data?.address)
                        editor.putString("phone", response.body()?.data?.data?.mobileNumber)
                        editor.putString("email", response.body()?.data?.data?.email)
                        editor.apply()

                        Toast.makeText(this@LoginActivity, "Welcome to Food Runner", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this@LoginActivity, MainActivity::class.java)
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)

                        startActivity(intent)
                        finish()
                    } else
                        Toast.makeText(
                            this@LoginActivity,
                            "Login failed ",
                            Toast.LENGTH_SHORT
                        ).show()


                }
                else{
                    Toast.makeText(
                        this@LoginActivity,
                        "Login failed Server Error Code: " + response.code(),
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }


        })
    }


}
