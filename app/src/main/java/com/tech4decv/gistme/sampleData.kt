package com.tech4decv.gistme

import com.tech4decv.gistme.Model.Chats
import com.tech4decv.gistme.Model.Message
import com.tech4decv.gistme.Model.User

class sampleData {
    val LIST_OF_FRIENDS : List<User> = listOf(
        User("James paul", "Hi there"),
        User("john ahmed", "I am on whatsapp" ),
        User("peace faith","nice to meet you"),
        User("esther thomas", "Hi there"),
        User("ephraim", "Hi there")
    )
}
class sampleMessage{
   val LIST_OF_MESSAGES : List<Message> = listOf(
        Message("joan okereke","9:00", "i am back", "peter simon"),
        Message("rick john","11:00", "i am learning programming","peter simon"),
        Message("job john","9:00", "i am back", "peter simon"),
        Message("john river","9:00", "i am tall", "peter simon"),
        Message("jan brown","9:00", "i am angry", "peter simon"),
        Message("joel pen","9:00", "i am teaching", "peter simon"),
    )
}
class SampleChats{
    val LIST_OF_CHATS : List<Chats> = listOf(
        Chats("joan okereke", listOf(
            Message("peter simon","9:00", "i am back", "joan okereke"),
            Message("joan okereke","8:00", "i am tired","peter simon"),
        )),
        Chats("rick john", listOf(
            Message("rick john","9:00", "i am back", "peter simon")
         )),
        Chats("john river", listOf(
            Message("john river","9:00", "i am tall", "peter simon"),
        )),
        Chats("jan brown", listOf(
            Message("jan brown","9:00", "i am angry", "peter simon"),
        )),
        Chats("joel pen", listOf(
            Message("joel pen","9:00", "i am teaching", "peter simon"),
        )),
    )

    fun getChatsOf(username:String):Chats?{
        for(item in LIST_OF_CHATS){
            if(item.sender==username){
                return item
            }
        }
        return null
    }
}