package com.tech4decv.gistme.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tech4decv.gistme.Model.Message
import com.tech4decv.gistme.R
import com.tech4decv.gistme.sampleMessage

class ListOFMessageAdapter (val context: Context) : RecyclerView.Adapter<ListOFMessageAdapter.MsgViewHolder>() {
    private val sampleMessage = sampleMessage()
    private val listOFMessage: List<Message> = sampleMessage.LIST_OF_MESSAGES

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MsgViewHolder {
        val itemView: View =
            LayoutInflater.from(context).inflate(R.layout.list_of_friends_layout, parent, false)
        return MsgViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MsgViewHolder, position: Int) {
        holder.username.text=listOFMessage[position].username
        holder.message.text=listOFMessage[position].message
    }

    override fun getItemCount(): Int = listOFMessage.size


    class MsgViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val username: TextView = itemView.findViewById(R.id.userName)
        val message : TextView= itemView.findViewById(R.id.status   )

    }

}