package com.example.activitywithfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_with_tabs.*

class ActivityWithTabs : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_with_tabs)

        //Set Up View Pager
        val differentScreensViewPagersAdapter = DifferentScreensViewPagersAdapter(this)
        viewPagerDifferentScreens.adapter = differentScreensViewPagersAdapter

        //Set Up Tab Layout
        TabLayoutMediator(tabLayoutDifferentScreens, viewPagerDifferentScreens){ tab, position ->
            when(position){
                0 -> {
                    tab.text = "Home"
                }
                1 -> {
                    tab.text = "Short"
                }
                else -> {
                    tab.text = "Subscription"
                }
            }
        }.attach()
    }
}