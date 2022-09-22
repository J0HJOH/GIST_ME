package com.tech4decv.gistme

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.tech4decv.gistme.adapters.MainPageAdapter
import com.tech4decv.gistme.extraActivities.CameraActivity
class MainActivity : AppCompatActivity() {
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar
    private lateinit var tabLayout : TabLayout
    private lateinit var viewPager : ViewPager2
    private lateinit var context : Context

    override fun onCreate(savedInstanceState: Bundle?) {
//        ensures the splash screen shows as you designed in the theme, once the application is created
        val splashScreen = installSplashScreen()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context = this

        toolbar = findViewById(R.id.MainToolbar)
        setSupportActionBar(toolbar)

        initTabLayout()
    }

    private fun initTabLayout() {
        tabLayout = findViewById(R.id.tab)

        viewPager = findViewById(R.id.viewPager)
        viewPager.adapter = MainPageAdapter(supportFragmentManager, lifecycle)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.icon = getDrawable(R.drawable.ic_baseline_photo_camera_24)
                1 -> tab.icon = getDrawable(R.drawable.ic_baseline_chat_24)
                2 -> tab.text = "Status"
                3 -> tab.icon = getDrawable(R.drawable.ic_baseline_call_24)
            }
        }.attach()

        viewPager.currentItem = 1

        viewPager.registerOnPageChangeCallback(
            object: ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    if(position==0){
                        val intent= Intent(context, CameraActivity::class.java)
                        startActivity(intent)
                        viewPager.currentItem=1
                    }
                }
            }
        )
    }


}