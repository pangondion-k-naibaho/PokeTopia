package com.client.poketopia.view.activity.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class AdapterFragmentHome(
    val fragmentManager: FragmentManager,
    val lifecycle: Lifecycle
): FragmentStateAdapter(fragmentManager, lifecycle) {
    val fragmentList: ArrayList<Fragment> = ArrayList<Fragment>()
    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList.get(position)
    }

}