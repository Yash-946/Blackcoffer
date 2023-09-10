package com.example.blackcoffer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.blackcoffer.exploreTab.BusinessFragment
import com.example.blackcoffer.exploreTab.MerchantFragment
import com.example.blackcoffer.exploreTab.PersonalFragment
import com.google.android.material.tabs.TabLayout

class Explore : Fragment() {

    private lateinit var  tablayout : TabLayout
    private lateinit var view: View
    private lateinit var viewpager : ViewPager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view =  inflater.inflate(R.layout.fragment_explore, container, false)

        tablayout = view.findViewById(R.id.tablayout)
        viewpager = view.findViewById(R.id.viewpager)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val fragmentsArrayList = ArrayList<Fragment>()
        fragmentsArrayList.add(PersonalFragment())
        fragmentsArrayList.add(BusinessFragment())
        fragmentsArrayList.add(MerchantFragment())


        val adapter = VPAdapter(childFragmentManager,fragmentsArrayList)
        viewpager.adapter = adapter

        tablayout.setupWithViewPager(viewpager)
    }

}