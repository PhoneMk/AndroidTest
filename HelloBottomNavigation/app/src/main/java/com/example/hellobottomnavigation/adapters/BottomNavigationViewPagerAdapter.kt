package com.example.hellobottomnavigation.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.hellobottomnavigation.fragments.HomeFragment
import com.example.hellobottomnavigation.fragments.NotificationFragment
import com.example.hellobottomnavigation.fragments.ProfileFragment

class BottomNavigationViewPagerAdapter (fragmentAcitvity: FragmentActivity): FragmentStateAdapter(fragmentAcitvity) {
    override fun getItemCount(): Int {
      return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> HomeFragment()
            1 -> NotificationFragment()
            2 -> ProfileFragment()
            else -> {
                HomeFragment()
            }
        }
    }

}