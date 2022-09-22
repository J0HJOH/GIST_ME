package com.tech4decv.gistme.extraActivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tech4decv.gistme.adapters.ListOfFriendsAdapter
import com.tech4decv.gistme.R

class NewBroadcastActivity : AppCompatActivity() {
    private lateinit var toolbar : Toolbar
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_broadcast)

        toolbar= findViewById(R.id.broadcastToolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        recyclerView= findViewById(R.id.listOfFriends)
        recyclerView.adapter= ListOfFriendsAdapter(this)
        recyclerView.layoutManager= LinearLayoutManager(this)

        //adding line decoration
        val decor = DividerItemDecoration(this, RecyclerView.VERTICAL)
        recyclerView.addItemDecoration(decor)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.search,menu)
        return super.onCreateOptionsMenu(menu)
    }
}