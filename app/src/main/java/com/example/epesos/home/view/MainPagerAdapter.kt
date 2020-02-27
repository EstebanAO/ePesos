package com.example.epesos.home.view

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.epesos.R

class MainPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a DetailTabFragment (defined as a static inner class below).
        return when (position) {
            0 -> PaymentFragment()
            1 -> PaymentFragment()
            2 -> PaymentFragment()
            3 -> PaymentFragment()
            4 -> PaymentFragment()
            else -> PaymentFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        val tabTitles = arrayOf(R.string.withdraw, R.string.payment, R.string.transaction, R.string.messages, R.string.chat)
        return context.resources.getString(tabTitles[position])
    }

    override fun getCount(): Int {
        return 5
    }
}