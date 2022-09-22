package com.tech4decv.gistme.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.tech4decv.gistme.Model.Message
import com.tech4decv.gistme.R

class ChatAdapter  (val context : Context, val listOfMessages:List<Message>): RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val itemView: View =LayoutInflater.from(context).inflate(R.layout.chats_layout, parent, false)

        return ChatViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
         val message: Message= listOfMessages[position]
//identifies, what kind of message shows on the right and on the left, like how we designed the layout
        if(message.Sender=="peter simon"){
            holder.messageSent.text = message.message
            holder.messageSentTime.text =message.time

            holder.leftSection.visibility =View.GONE

        }else {
            holder.senderMessage.text = message.message
            holder.sendTime.text = message.time

            holder.rightSection.visibility=View.GONE
        }
    }

    override fun getItemCount(): Int {
        return listOfMessages.size
    }
    class ChatViewHolder( itemView: View): RecyclerView.ViewHolder(itemView){
        val senderMessage: TextView=itemView.findViewById(R.id.SenderMessage)
        val sendTime: TextView=itemView.findViewById(R.id.sendTime)
        val messageSent: TextView=itemView.findViewById(R.id.MessageSent)
        val messageSentTime: TextView=itemView.findViewById(R.id.MessageSentTime)

        val leftSection : CardView  = itemView.findViewById(R.id.senderSection)
        val rightSection : CardView = itemView.findViewById(R.id.userSection)

    }

}