package com.tech4decv.gistme.fragment

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tech4decv.gistme.adapters.ListOFMessageAdapter
import com.tech4decv.gistme.R
import com.tech4decv.gistme.extraActivities.NewBroadcastActivity
import com.tech4decv.gistme.extraActivities.NewGroupActivity
import com.tech4decv.gistme.starredMessageActivity


class ChatFragment : Fragment() {
    private lateinit var chatRecycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.app_bar_search->{
                Toast.makeText(requireContext(),"search click", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.linked_device->{
                Toast.makeText(requireContext(), "linked device click", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.new_broadcast ->{
                goToNewBroadcast()
                return true
            }
            R.id.settings ->{
                Toast.makeText(requireContext(), "settings click", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.new_group->{
                goToNewGroupActivity()
                return true
            }
            R.id.starred_messages->{
                goToStarredMessage()
                return true
            }else-> {
            return false
        }

        }
    }

    private fun goToNewGroupActivity(){
        val i = Intent(requireContext(), NewGroupActivity ::class.java)
        startActivity(i)

    }
    private fun goToNewBroadcast(){
        val i = Intent(requireContext(), NewBroadcastActivity ::class.java )
        startActivity(i)
    }
    private fun goToStarredMessage(){
        val a = Intent(requireContext(), starredMessageActivity::class.java)
        startActivity(a)
    }
}