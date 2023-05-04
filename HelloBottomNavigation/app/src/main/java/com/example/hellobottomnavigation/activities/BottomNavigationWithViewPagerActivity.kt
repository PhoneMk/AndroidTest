package com.example.hellobottomnavigation.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.hellobottomnavigation.R
import com.example.hellobottomnavigation.adapters.BottomNavigationViewPagerAdapter
import kotlinx.android.synthetic.main.activity_bottom_navigation_with_view_pager.*

class BottomNavigationWithViewPagerActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation_with_view_pager)

        viewPager.adapter = BottomNavigationViewPagerAdapter(this)
        viewPager.currentItem = 0

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when(position) {
                    0 -> bottom_nav.selectedItemId = R.id.action_home
                    1 -> bottom_nav.selectedItemId = R.id.action_notification
                    2 -> bottom_nav.selectedItemId = R.id.action_profile
                }
            }
        })

        //change view pager when bottom nav is changed
        bottom_nav.setOnNavigationItemSelectedListener { menuItem: MenuItem ->
            when(menuItem.itemId) {
                R.id.action_home -> {
                    viewPager.currentItem = 0
                    true
                }
                R.id.action_notification -> {
                    viewPager.currentItem = 1
                    true
                }
                R.id.action_profile -> {
                    viewPager.currentItem = 2
                    true
                }
            }
            false
        }
    }
}