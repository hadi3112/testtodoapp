package com.hadi.testtodoapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter


class ViewPagerAdapter(fa: FragmentActivity?) : FragmentStateAdapter(fa!!)

{
    override fun createFragment(pos: Int): Fragment {
        return when (pos) {
            0 -> {
                SigninFragment()
            }
            1 -> {
                SignUpFragment()
            }
            else -> {
                SigninFragment()     //set this as default tab
            }
        }
    }

    override fun getItemCount(): Int {
        return 2
    }
}