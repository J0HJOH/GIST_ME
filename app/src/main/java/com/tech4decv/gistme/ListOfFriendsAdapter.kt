package com.tech4decv.gistme

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ListOfFriendsAdapter(val context:Context) : RecyclerView.Adapter<ListOfFriendsAdapter.LFViewholder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LFViewholder {
        val itemView= LayoutInflater.from(context).inflate(R.layout.list_of_friends_layout,parent,false )
        return LFViewholder(itemView)
    }

    override fun onBindViewHolder(holder: LFViewholder, position: Int) {

    }

    override fun getItemCount(): Int {

    }
    class LFViewholder(itemView: View):RecyclerView.ViewHolder(itemView){

    }

}