package com.example.hellobottomnavigation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.hellobottomnavigation.R
import com.example.hellobottomnavigation.fragments.HomeFragment
import com.example.hellobottomnavigation.fragments.NotificationFragment
import com.example.hellobottomnavigation.fragments.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        switchFragment(HomeFragment())

        bottom_navigation.setOnNavigationItemSelectedListener { menuItem: MenuItem ->
            when(menuItem.itemId){
                R.id.action_home -> {
                    switchFragment(HomeFragment())
                }
                R.id.action_notification -> {
                    switchFragment(NotificationFragment())
                }
                R.id.action_profile -> {
                    switchFragment(ProfileFragment())
                }
            }
            false
        }
    }

    private fun switchFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fl_container,fragment)
            .commit()
    }
}