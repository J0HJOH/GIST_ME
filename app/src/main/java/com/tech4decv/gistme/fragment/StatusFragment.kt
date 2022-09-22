package com.tech4decv.gistme.fragment

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.tech4decv.gistme.R
import com.tech4decv.gistme.adapters.StatusAdapter
import com.tech4decv.gistme.extraActivities.CameraActivity


class StatusFragment : Fragment() {
    private lateinit var statusRecyclerView : RecyclerView
    private lateinit var statusCamera : FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_status, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initStatusRecyclerView(view)

        statusCamera= view.findViewById(R.id.statusCamera)
        statusCamera.setOnClickListener {
            val intent= Intent(requireContext(), CameraActivity::class.java)
            requireContext().startActivity(intent)
        }
    }

    private fun initStatusRecyclerView(view: View) {
        statusRecyclerView = view.findViewById(R.id.statusRV)
        statusRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        statusRecyclerView.adapter = StatusAdapter(requireContext())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.status_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.privacy->{
                Toast.makeText(requireContext(),"Let's go private", Toast.LENGTH_LONG).show()
                true
            }
            R.id.statusSettings->{
                Toast.makeText(requireContext(),"What would you like to change?", Toast.LENGTH_LONG).show()
                true
            }else ->{
                false
            }
        }
    }
}