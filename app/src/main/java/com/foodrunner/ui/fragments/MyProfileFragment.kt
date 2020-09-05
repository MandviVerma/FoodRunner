package com.foodrunner.ui.fragments

import android.content.Context
import android.content.SharedPreferences
import androidx.fragment.app.Fragment
import com.foodrunner.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_my_profile.*

class MyProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_my_profile, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val prefs: SharedPreferences = activity?.getSharedPreferences("Food Runner", Context.MODE_PRIVATE)!!

        tv_profile_name.text = prefs.getString("name","")
        tv_phone_no.text=prefs.getString("phone","")
        tv_email.text=prefs.getString("email","")
        tv_city.text=prefs.getString("address","")
    }

}



