package com.tech4decv.gistme.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.tech4decv.gistme.fragment.CallsFragment
import com.tech4decv.gistme.fragment.CameraFragment
import com.tech4decv.gistme.fragment.ChatFragment
import com.tech4decv.gistme.fragment.StatusFragment

class MainPageAdapter(fm:FragmentManager,lf:Lifecycle): FragmentStateAdapter(fm, lf) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 ->  CameraFragment()
            1 ->  ChatFragment()
            2 ->  StatusFragment()
            3 ->  CallsFragment()

            else -> return ChatFragment()
        }
    }
}