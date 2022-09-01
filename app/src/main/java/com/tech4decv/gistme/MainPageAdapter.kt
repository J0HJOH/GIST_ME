package com.tech4decv.gistme

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

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