package com.example.epesos.home.view

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.example.epesos.R
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    lateinit var tabs : TabLayout
    lateinit var viewPager: ViewPager
    lateinit var sectionsPagerAdapter : MainPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        sectionsPagerAdapter = MainPagerAdapter(this, supportFragmentManager)
        viewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        viewPager.offscreenPageLimit = 1
        tabs = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)

        tabs.getTabAt(0)!!.icon = ContextCompat.getDrawable(this, R.drawable.ic_withdraw)
        tabs.getTabAt(1)!!.icon = ContextCompat.getDrawable(this, R.drawable.ic_payment)
        tabs.getTabAt(2)!!.icon = ContextCompat.getDrawable(this, R.drawable.ic_transaction)
        tabs.getTabAt(3)!!.icon = ContextCompat.getDrawable(this, R.drawable.ic_message)
        tabs.getTabAt(4)!!.icon = ContextCompat.getDrawable(this, R.drawable.ic_chat)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
