package com.tech4decv.gistme

import com.tech4decv.gistme.Model.Message
import com.tech4decv.gistme.Model.User

class sampleData {
    val LIST_OF_FRIENDS : List<User> = listOf(
        User("James paul", "Hi there"),
        User("john ahmed", "I am on whatsapp" ),
        User("peace fait" +
                "h","nice to meet you"),
        User("esther thomas", "Hi there"),
        User("ephraim", "Hi there")
    )
}
class sampleMessage{
    val LIST_OF_MESSAGES : List<Message> = listOf(
        Message("joan john","9:00", "i am back"),
        Message("peter simon","10:00", "i am in school"),
        Message("joan john","8:00", "i am back"),
        Message("joan john","11:00", "i am learning programming"),
    )

}