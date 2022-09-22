package com.tech4decv.gistme.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tech4decv.gistme.Model.Call
import com.tech4decv.gistme.R
import com.tech4decv.gistme.SampleCalls

class CallAdapter(val context: Context):RecyclerView.Adapter<CallAdapter.CallViewHolder>() {
    val sampleCalls = SampleCalls()
    val listOfCalls: MutableList<Call> = sampleCalls.LIST_OF_CALLS

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CallViewHolder {
        val itemView :View = LayoutInflater.from(context).inflate(R.layout.call_layout, parent,false)
        return  CallViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: CallViewHolder, position: Int) {
        holder.name.text = listOfCalls[position].name
        holder.date.text = listOfCalls[position].date

    }

    override fun getItemCount(): Int = listOfCalls.size

    class CallViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val name : TextView = itemView.findViewById(R.id.username)
        val date : TextView = itemView.findViewById(R.id.CallTime)
    }



}