package com.foodrunner.ui.activities

import android.app.AlertDialog
import android.app.SearchManager
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.foodrunner.R
import com.foodrunner.db.AppDatabase
import com.foodrunner.db.RoomDao
import com.foodrunner.ui.auth.LoginActivity
import com.foodrunner.ui.fragments.*
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_sort.view.*


class MainActivity : AppCompatActivity() {

    lateinit var searchView: SearchView
    lateinit var drawerLayout: DrawerLayout
    lateinit var frameLayout: FrameLayout
    lateinit var navigationView: NavigationView
    var previousMenuItem: MenuItem? = null

    val fragment = HomeFragment()
    var menu: Menu? = null


    lateinit var dao: RoomDao
    lateinit var prefs: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawerLayout)
        frameLayout = findViewById(R.id.frameLayout)
        navigationView = findViewById(R.id.navigationView)

        dao = AppDatabase.getInstance(this).RoomDao()
        prefs = getSharedPreferences("Food Runner", Context.MODE_PRIVATE)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Food Runner"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this@MainActivity,
            drawerLayout,
            R.string.open_drawer,
            R.string.close_drawer
        )
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        navigationView.setCheckedItem(R.id.Home)


        openMainFragment()

//        supportActionBar?.title = "Food Runner"
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        supportActionBar?.setHomeButtonEnabled(true)

        val tvName = navigationView.getHeaderView(0).findViewById<TextView>(R.id.userName)
        val tvEmail = navigationView.getHeaderView(0).findViewById<TextView>(R.id.userEmail)

        if (prefs.getString("name", "") != "") {
            tvName.text = prefs.getString("name", "")
        }
        if (prefs.getString("email", "") != "") {
            tvEmail.text = prefs.getString("email", "")
        }

        navigationView.setNavigationItemSelectedListener {
            if (previousMenuItem != null) {
                previousMenuItem!!.isChecked = false
            }
            it.isCheckable = true
            it.isChecked = true
            previousMenuItem = it

            when (it.itemId) {
                R.id.Home -> {
                    openMainFragment()
                    supportActionBar?.title = "Food Runner"
                    drawerLayout.closeDrawer(GravityCompat.START)
                    showOptionMenu(true)

                }
                R.id.my_profile -> {
                    val profileFragment = MyProfileFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, profileFragment).commit()
                    supportActionBar?.title = "My Profile"
                    drawerLayout.closeDrawer(GravityCompat.START)
                    showOptionMenu(false)


                    // Toast.makeText(this@MainActivity,"Clicked on Profile",Toast.LENGTH_SHORT).show()
                }
                R.id.favourite_restaurants -> {
                    val favoriteFragment = FavoritesFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, favoriteFragment).commit()
                    supportActionBar?.title = "Favourites Restaurant"
                    drawerLayout.closeDrawer(GravityCompat.START)
                    showOptionMenu(false)
                }
                R.id.faqs -> {
                    val faqsFragment = FaqFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, faqsFragment).commit()
                    supportActionBar?.title = "Faqs"
                    drawerLayout.closeDrawer(GravityCompat.START)
                    showOptionMenu(false)
                    //Toast.makeText(this@MainActivity,"Clicked on FAQ",Toast.LENGTH_SHORT).show()
                }

                R.id.order_history -> {
                    val favoriteFragment = OrderHistoryFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, favoriteFragment).commit()
                    supportActionBar?.title = "Orders History"
                    drawerLayout.closeDrawer(GravityCompat.START)
                    showOptionMenu(false)
                }
                R.id.logout -> {

                    val builder = AlertDialog.Builder(this)

                    builder.setMessage("Do you want to logout this application ?")
                        .setCancelable(false)
                        .setPositiveButton("Yes") { dialog: DialogInterface, i: Int ->
                            prefs.edit().clear().apply()
                            startActivity(Intent(this, LoginActivity::class.java))
                            finish()
                        }
                        .setNegativeButton("No") { dialog: DialogInterface, i: Int ->
                            dialog.cancel()
                        }

                    val alert = builder.create()
                    alert.setTitle("LOGOUT")
                    alert.show()
                }
            }
            return@setNavigationItemSelectedListener true


        }


    }


    private fun openMainFragment() {

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout, fragment)
        transaction.commit()
    }


    private fun showOptionMenu(visible: Boolean) {
        if (menu == null)
            return
        menu?.setGroupVisible(R.id.menu_group, visible)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        this.menu = menu

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        searchView = menu.findItem(R.id.action_search).actionView as SearchView
        searchView.setSearchableInfo(
            searchManager
                .getSearchableInfo(componentName)
        )
        searchView.maxWidth = Integer.MAX_VALUE

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                fragment.restaurantsAdapter.filter.filter(query)
                return false
            }

            override fun onQueryTextChange(query: String): Boolean {
                fragment.restaurantsAdapter.filter.filter(query)
                return false
            }
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            if (drawerLayout.isDrawerOpen(GravityCompat.START))
                drawerLayout.closeDrawer(GravityCompat.START)
            else
                drawerLayout.openDrawer(GravityCompat.START)

        } else if (id == R.id.action_search) {
            return true
        } else if (id == R.id.action_sort) {

            showSortFilter(
                BottomSheetDialog(this, R.style.BaseBottomSheetDialog),
                this, R.layout.dialog_sort
            )
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    fun showSortFilter(
        popupWindow: BottomSheetDialog?,
        activity: MainActivity,
        layout: Int
    ): BottomSheetDialog? {

        val popupView = LayoutInflater.from(activity).inflate(layout, null)
        popupWindow?.setContentView(popupView)
        popupWindow?.show()


        var sortParam = ""
        popupView.btn_apply.isEnabled = false
        popupView.btn_apply.setBackgroundColor(Color.parseColor("#fed8b1"))

        if (prefs.getString("SortParam", "") != "") {

            if (prefs.getString("SortParam", "") == "Cost")
                popupView.rbCost.isChecked = true
            else if (prefs.getString("SortParam", "") == "Rating")
                popupView.rbRating.isChecked = true

            sortParam = prefs.getString("SortParam", "") ?: ""
            popupView.btn_apply.isEnabled = true
            popupView.btn_apply.setBackgroundColor(Color.parseColor("#ff7d18"))


        }

        popupView.radioGroup?.setOnCheckedChangeListener { radioGroup: RadioGroup, i: Int ->
            sortParam = if (radioGroup.checkedRadioButtonId == R.id.rbCost)
                "Cost"
            else
                "Rating"

            popupView.btn_apply.isEnabled = true
            popupView.btn_apply.setBackgroundColor(Color.parseColor("#ff7d18"))

        }

        popupView.btn_apply?.setOnClickListener {
            prefs.edit().putString("SortParam", sortParam).apply()
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frameLayout, HomeFragment())
            transaction.commit()
            popupWindow?.dismiss()
        }

        popupView.tvClear?.setOnClickListener {
            sortParam = ""
            prefs.edit().putString("SortParam", sortParam).apply()
            onBackPressed()
            popupView.radioGroup.clearCheck()
            popupView.btn_apply.isEnabled = false
            popupView.btn_apply.setBackgroundColor(Color.parseColor("#fed8b1"))

        }
        return popupWindow

    }

    override fun onBackPressed() {
        val fm = supportFragmentManager.findFragmentById(R.id.frameLayout)
        prefs.edit().remove("SortParam").apply()

        if (fm != fragment) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frameLayout, fragment)
            transaction.commit()
        } else
            super.onBackPressed()
    }
}
