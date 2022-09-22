package com.tech4decv.gistme.fragment

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tech4decv.gistme.R
import com.tech4decv.gistme.adapters.CallAdapter


class CallsFragment : Fragment() {
    private lateinit var CallRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calls, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        CallRecyclerView = view.findViewById(R.id.CallRV)
        CallRecyclerView.layoutManager= LinearLayoutManager(requireContext())
        CallRecyclerView.adapter = CallAdapter(requireContext())
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.call_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.clearCallLog->{
                Toast.makeText(requireContext(),"Clear Call History", Toast.LENGTH_LONG).show()
                true
            }
            R.id.CallSettings->{
                Toast.makeText(requireContext(),"What would you like to change?", Toast.LENGTH_LONG).show()
                true
            }else ->{
                false
            }
        }
    }

}