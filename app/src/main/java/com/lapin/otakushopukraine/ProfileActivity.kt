package com.lapin.otakushopukraine


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView

import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout


class ProfileActivity : AppCompatActivity() {
    private lateinit var userNameView: TextView
    private lateinit var userAvatar: ImageView
    private lateinit var dateBirthView: TextView
    private lateinit var userEmailView: TextView
    var tabLayout: TabLayout? = null
    var viewPager: ViewPager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        title =  "Особистий кабінет"
        userAvatar = findViewById<ImageView>(R.id.userPhoto)
        userNameView = findViewById<TextView>(R.id.userFullName)
        //dateBirthView = findViewById<TextView>(R.id.userDateOfBirth)
      //  userEmailView = findViewById(R.id.EmailView)
        //TestSets
        userAvatar.setImageResource(R.drawable.authorphoto)
        userNameView.setText("Лапін Костянтин Едуардович")

        viewPager = findViewById<ViewPager>(R.id.viewPager)
        tabLayout = findViewById<TabLayout>(R.id.tabLayout)


        tabLayout!!.addTab(tabLayout!!.newTab().setText("Головна"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("Доставка і оплата"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("Безпека"))
        tabLayout!!.tabGravity = TabLayout.GRAVITY_FILL

        val adapter = MyAdapter(this, supportFragmentManager, tabLayout!!.tabCount)
        viewPager!!.adapter = adapter

        viewPager!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager!!.currentItem = tab.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {

            }
            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })


    }




}
