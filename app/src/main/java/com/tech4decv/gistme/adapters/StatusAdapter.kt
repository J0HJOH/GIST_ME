package com.tech4decv.gistme.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tech4decv.gistme.Model.Status
import com.tech4decv.gistme.R
import com.tech4decv.gistme.SampleStatus

class StatusAdapter(val context: Context):RecyclerView.Adapter<StatusAdapter.StatusViewHolder>() {
    val sampleStatus = SampleStatus()
    val listOfStatus : List<Status> = sampleStatus.LIST_OF_STATUS
    class StatusViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val username : TextView = itemView.findViewById(R.id.username)
        val uploadTime: TextView = itemView.findViewById(R.id.statusTime)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatusViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.status_layout, parent,false)

        return StatusViewHolder(view)
    }

    override fun onBindViewHolder(holder: StatusViewHolder, position: Int) {
        val theName: String = listOfStatus[position].name
        val theTime : String = listOfStatus[position].time
        holder.username.text = theName
        holder.uploadTime.text = theTime
    }

    override fun getItemCount(): Int {
       return listOfStatus.size
    }
}