package com.tech4decv.gistme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.EditText
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.tech4decv.gistme.adapters.ChatAdapter
import com.tech4decv.gistme.Model.Chats
import com.tech4decv.gistme.Model.Message
import java.text.SimpleDateFormat
import java.util.*

class ChatActivity : AppCompatActivity() {
    private lateinit var MSRecyclerView: RecyclerView
    private lateinit var toolbar: Toolbar
    private lateinit var messageTyped : EditText
    private lateinit var sendButton : FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
       // Gets username from the intent that starts the activity
        val username : String= intent.getStringExtra("USER")?:""
//        initialized the var sampleChats to have properties of object SampleChats()
        val sampleChats= SampleChats()
//        gets the chat details of a specified user(username), it could be a null value because of (?)
        val chat: Chats? = sampleChats.getChatsOf(username)
//        gets the messages of the chat specified, and a value of type List of message must be passed
//        because of the asertion (!!)
        val listOfMessages:MutableList<Message> = chat!!.message.toMutableList()
//  Refactored these two, to be a function that has the specified dependencies written here()
        initChatToolbar(username)
        setUpChatRecycler(listOfMessages)

        messageTyped =findViewById(R.id.messageInput)
        sendButton = findViewById(R.id.sendButton)
        sendButton.setOnClickListener{
//get user input
            val userInput : String = messageTyped.text.toString()?:""
            //update listOf message above
            val sdf = SimpleDateFormat("h:mm a")
            val time: String= sdf.format(Date())
//            create a message type
            val message = Message (
                Sender = "peter simon",
                time = time,
                message = userInput,
                receiver = username
            )
//            adds the message to the list of messages
            listOfMessages.add(message)
            setUpChatRecycler(listOfMessages)

            messageTyped.setText("")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.chat_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun setUpChatRecycler(listOfMessages:List<Message>) {
        MSRecyclerView = findViewById(R.id.messageBody)
        MSRecyclerView.layoutManager = LinearLayoutManager(this)
        MSRecyclerView.adapter = ChatAdapter(this, listOfMessages)
    }

    private fun initChatToolbar(username:String) {
        toolbar = findViewById(R.id.ChatToolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = username
    }
}