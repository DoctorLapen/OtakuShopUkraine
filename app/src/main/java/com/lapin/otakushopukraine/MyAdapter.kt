package com.lapin.otakushopukraine

import android.content.Context;

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MyAdapter(private val myContext: Context, fm: FragmentManager, internal var totalTabs: Int) : FragmentPagerAdapter(fm) {

    // this is for fragment tabs
    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                //  val homeFragment: HomeFragment = HomeFragment()
                return ProfileMainFragment()
            }
            1 -> {
                return DeliveryFragment()
            }
            2 -> {
                // val movieFragment = MovieFragment()
                return SecurityFragment()
            }

        }
        return ProfileMainFragment()
    }

    // this counts total number of tabs
    override fun getCount(): Int {
        return totalTabs
    }
}