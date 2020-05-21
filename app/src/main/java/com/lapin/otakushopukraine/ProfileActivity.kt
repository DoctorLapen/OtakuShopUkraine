package com.lapin.otakushopukraine


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        dateBirthView = findViewById<TextView>(R.id.userDateOfBirth)
        userEmailView = findViewById(R.id.EmailView)
        //TestSets
        userAvatar.setImageResource(R.drawable.authorphoto)
        userNameView.setText("Лапін Костянтин Едуардович")
        val date = "28.02.2000"
        dateBirthView.text = date
        userEmailView.text = getString (R.string.testEmail);
        viewPager = findViewById<ViewPager>(R.id.viewPager)
        tabLayout = findViewById<TabLayout>(R.id.tabLayout)


        tabLayout!!.addTab(tabLayout!!.newTab().setText("Home"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("Sport"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("Movie"))
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
