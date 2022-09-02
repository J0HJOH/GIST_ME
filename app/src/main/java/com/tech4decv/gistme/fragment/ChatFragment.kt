package com.tech4decv.gistme.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tech4decv.gistme.Adapters.ListOFMessageAdapter
import com.tech4decv.gistme.Adapters.ListOfFriendsAdapter
import com.tech4decv.gistme.R


class ChatFragment : Fragment() {
    private lateinit var chatRecycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        chatRecycler=view.findViewById(R.id.chatRecycler)

        chatRecycler.adapter= ListOFMessageAdapter(requireContext())
        chatRecycler.layoutManager= LinearLayoutManager(requireContext())
    }
}