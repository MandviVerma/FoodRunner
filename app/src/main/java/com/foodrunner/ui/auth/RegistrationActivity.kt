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
import com.foodrunner.model.AuthModel
import com.foodrunner.model.AuthModelResponse
import com.foodrunner.ui.activities.MainActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_registration.*
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RegistrationActivity : AppCompatActivity() {

    lateinit var dao: RoomDao
    lateinit var prefs: SharedPreferences
    var BASE_URL = "http://13.235.250.119/"
    lateinit var httpClient: OkHttpClient.Builder
    lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        supportActionBar?.hide()

        dao = AppDatabase.getInstance(this).RoomDao()
        prefs = getSharedPreferences("Food Runner", Context.MODE_PRIVATE)


        httpClient = OkHttpClient.Builder()
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()



        btnRegister.setOnClickListener {
            registerUser()
        }
    }


    private fun registerUser() {

        if (check()) {
            if (et_name.text.toString().length < 3)
                Toast.makeText(this, "Name should be min. 3 Characters", Toast.LENGTH_SHORT).show()
            else if (et_mobile_number.text.toString().length != 10)
                Toast.makeText(this, "Invalid Phone number", Toast.LENGTH_SHORT).show()
            else if (et_password.text.toString().length < 4)
                Toast.makeText(this, "Password should be min. 4 characters", Toast.LENGTH_SHORT)
                    .show()
            else if (et_password.text.toString() != et_confirm_password.text.toString())
                Toast.makeText(this, "Password doesn't match", Toast.LENGTH_SHORT).show()
            else if (!et_email.text.toString().contains("@") && !et_email.text.toString()
                    .contains(".com")
            )
                Toast.makeText(this, "Invalid Email", Toast.LENGTH_SHORT).show()
            else {

                val authModel = AuthModel(
                    et_name.text.toString(),
                    et_mobile_number.text.toString(),
                    et_password.text.toString(),
                    et_delivery_address.text.toString(),
                    et_email.text.toString())

                Log.i("g", Gson().toJson(authModel))
                registerUser(authModel)

                //RegisterUserAsyncTask(this,authModel).execute()
            }

        } else
            Toast.makeText(this, "Fill all the details", Toast.LENGTH_SHORT).show()

    }

    private fun registerUser(authModel: AuthModel) {

        val api = retrofit.create(FoodRunnerService::class.java)

        val call = api.registerUser(authModel)

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

                if (response.body()?.data?.success!!) {
                    val editor = prefs.edit()
                    editor.putString("userId", response.body()?.data?.data?.userId)
                    editor.putString("name", response.body()?.data?.data?.name)
                    editor.putString("address", response.body()?.data?.data?.address)
                    editor.putString("phone", response.body()?.data?.data?.mobileNumber)
                    editor.putString("email", response.body()?.data?.data?.email)
                    editor.apply()

                    Toast.makeText(
                        this@RegistrationActivity,
                        "Successfully registered",
                        Toast.LENGTH_SHORT
                    ).show()
                    val intent = Intent(
                        this@RegistrationActivity,
                        MainActivity::class.java
                    )
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)

                    startActivity(intent)
                    finish()
                } else
                    Toast.makeText(
                        this@RegistrationActivity,
                        "Registration failed " + response.body()?.data?.errorMessage,
                        Toast.LENGTH_SHORT
                    ).show()


            }


        })
    }


    private fun check(): Boolean {

        return (et_name.text.toString() != ""
                && et_mobile_number.text.toString() != ""
                && et_delivery_address.text.toString() != ""
                && et_email.text.toString() != ""
                && et_password.text.toString() != ""
                && et_confirm_password.text.toString() != "")
    }
}


