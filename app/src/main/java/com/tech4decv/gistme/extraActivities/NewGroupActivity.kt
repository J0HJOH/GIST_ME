package com.tech4decv.gistme.extraActivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tech4decv.gistme.Adapters.ListOfFriendsAdapter
import com.tech4decv.gistme.R

class NewGroupActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_group)

        recyclerView= findViewById(R.id.listOfFriends)
        recyclerView.adapter= ListOfFriendsAdapter(this)
        recyclerView.layoutManager= LinearLayoutManager(this)

        //adding line decoration
        val decor = DividerItemDecoration(this,RecyclerView.VERTICAL)
        recyclerView.addItemDecoration(decor)
    }


}