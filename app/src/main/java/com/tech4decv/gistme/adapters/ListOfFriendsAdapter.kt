package com.tech4decv.gistme.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tech4decv.gistme.R
import com.tech4decv.gistme.sampleData

class ListOfFriendsAdapter(val context:Context) : RecyclerView.Adapter<ListOfFriendsAdapter.LFViewholder>() {
    private val sampleData = sampleData()
    private val listOfFriends= sampleData.LIST_OF_FRIENDS

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LFViewholder {
        val itemView= LayoutInflater.from(context).inflate(R.layout.list_of_friends_layout,parent,false )
        return LFViewholder(itemView)
    }

    override fun onBindViewHolder(holder: LFViewholder, position: Int) {
        holder.userName.text =listOfFriends[position].username
        holder.status.text =listOfFriends[position].status

    }

    override fun getItemCount(): Int {
        return listOfFriends.size
    }
    class LFViewholder(itemView: View):RecyclerView.ViewHolder(itemView){
        val userName: TextView= itemView.findViewById(R.id.userName)
        val status: TextView= itemView.findViewById(R.id.status)
    }

}