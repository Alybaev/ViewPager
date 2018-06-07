package com.icoder.viewpager

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.widget.Toast
import com.icoder.viewpager.fragments.FragmentOne
import com.icoder.viewpager.fragments.FragmentTwo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var custom: CustomAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        custom = CustomAdapter(supportFragmentManager, applicationContext)

        view_pager.adapter = custom

        tabLayout?.setupWithViewPager(view_pager)
        tabLayout?.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {
                view_pager.currentItem = tab!!.position
                Toast.makeText(applicationContext,"Tab selected",Toast.LENGTH_SHORT).show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                view_pager.currentItem = tab!!.position
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                view_pager.currentItem = tab!!.position
            }
        })

        }


    }

    class CustomAdapter : FragmentPagerAdapter {
        var frgOne = FragmentOne()
        var frgTwo = FragmentTwo()

        private val fragments = arrayOf("Fragment 1", "Fragment 2")

        constructor(fragment: FragmentManager, applicationContext: Context) : super(fragment)

        override fun getItem(position: Int): Fragment? {
            when (position) {
                0 -> return FragmentOne()
                1 -> return FragmentTwo()
            }
            return null
        }


        override fun getCount(): Int {
            return fragments.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return fragments[position]
        }
    }


