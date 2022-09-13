package com.tech4decv.gistme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.tech4decv.gistme.Adapters.MainPageAdapter
import com.tech4decv.gistme.extraActivities.NewBroadcastActivity
import com.tech4decv.gistme.extraActivities.NewGroupActivity

class MainActivity : AppCompatActivity() {
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar
    private lateinit var tabLayout : TabLayout
    private lateinit var viewPager : ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

                else -> tab.icon = getDrawable(R.drawable.ic_baseline_chat_24)
            }
        }.attach()

        viewPager.currentItem = 1
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
            when(item.itemId){
                R.id.app_bar_search->{
                    Toast.makeText(this,"search click", Toast.LENGTH_LONG).show()
                    return true
                }
                R.id.linked_device->{
                    Toast.makeText(this, "linked device click", Toast.LENGTH_LONG).show()
                    return true
                }
                R.id.new_broadcast ->{
                    goToNewBroadcast()
                    return true
                }
                R.id.settings ->{
                    Toast.makeText(this, "settings click", Toast.LENGTH_LONG).show()
                    return true
                }
                R.id.new_group->{
                    goToNewGroupActivity()
                    return true
                }
                R.id.starred_messages->{
                    goToStarredMessage()
                    return true
                }else-> {
                    return false
                }

            }
    }
    private fun goToNewGroupActivity(){
        var i = Intent(this, NewGroupActivity ::class.java)
        startActivity(i)

    }
    private fun goToNewBroadcast(){
        var i = Intent(this, NewBroadcastActivity ::class.java )
        startActivity(i)
    }
    private fun goToStarredMessage(){
        var a = Intent(this, starredMessageActivity::class.java)
        startActivity(a)
    }
}