package com.hadi.testtodoapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator



class OnBoardingActivity: AppCompatActivity() {

    private lateinit var navgraphController:NavController
    var viewPager: ViewPager2? = null
    var pagerAdapter: FragmentStateAdapter? = null
    val tabtitles = arrayOf("Log in", "Sign Up")
    var tablayout: TabLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        viewPager = findViewById(R.id.viewPager);      //FIX: should use mvvm architecture instead
        tablayout = findViewById(R.id.tabLayout)

        pagerAdapter = ViewPagerAdapter(this)
        viewPager!!.adapter = pagerAdapter

        //inflating tab layout

        TabLayoutMediator(tablayout!!, viewPager!!) { tab, position ->
            viewPager!!.setCurrentItem(tab.position, false)
            if (position == 0)
            { tab.setText(tabtitles[position]) }
            if (position == 1)
            {
                tab.setText(tabtitles[position])
            }
        }.attach()



    }

}
