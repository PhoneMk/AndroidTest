package com.example.activitywithfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.activitywithfragments.HomeFragment.Companion.KEY_HOME_DESCRIPTION
import com.example.activitywithfragments.ShortsFragment.Companion.KEY_SHORTS_DESCRIPTION

class DifferentScreensViewPagersAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
       return when(position){
            0 -> {
                val homeFragment = HomeFragment()

                // Pass Data
                val bundle = Bundle()
                bundle.putString(KEY_HOME_DESCRIPTION, "This is Home Fragment")
                homeFragment.arguments = bundle

                return homeFragment
            }
            1 -> {
                val shortsFragment = ShortsFragment()

                // Pass Data
                val bundle = Bundle().apply {
                    this.putString(KEY_SHORTS_DESCRIPTION, "This is Shorts Fragment")
                }
                shortsFragment.arguments = bundle
//                val bundle = Bundle()
//                bundle.putString(KEY_SHORTS_DESCRIPTION, "This is Shorts Fragment")
                return shortsFragment
            }
            else -> SubscriptionFragment()
        }
    }

}