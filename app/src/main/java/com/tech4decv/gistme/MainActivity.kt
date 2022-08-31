package com.tech4decv.gistme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit tabLayout : TabLayout
    private lateinit viewPager : viewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tablayout = findViewById(R.id.tab)
        viewpager = findViewById(R.id.viewpager)
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
                    Toast.makeText(this, "starred messages click", Toast.LENGTH_LONG).show()
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
        var i = Intent(this, NewBroadcast ::class.java )
        startActivity(i)
    }
}