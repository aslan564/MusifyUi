package com.aslanovaslan.inlinechats

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.aslanovaslan.inlinechats.adapter.PlayerViewPagerAdapter
import com.aslanovaslan.inlinechats.fragments.FirstFragment
import com.aslanovaslan.inlinechats.fragments.SecondFragment
import kotlinx.android.synthetic.main.activity_player_studio.*
import kotlinx.android.synthetic.main.fragment_first.*

class PlayerStudio : AppCompatActivity() {
    private lateinit var viewPagerPlayerAdapter:PlayerViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_studio)


       setupPlayerPager()
    }

    private fun setupPlayerPager() {
       viewPagerPlayerAdapter = PlayerViewPagerAdapter(supportFragmentManager)
        viewPagerPlayer.adapter = viewPagerPlayerAdapter
        viewPagerPlayerAdapter.addFragment(FirstFragment(),"New")
        viewPagerPlayerAdapter.addFragment(SecondFragment(),"Trendy")
        viewPagerPlayerAdapter.addFragment(FirstFragment(),"Best Rated")
        viewPagerPlayer.adapter=viewPagerPlayerAdapter
        tabLayoutPlayer.setupWithViewPager(viewPagerPlayer)
        tabLayoutPlayer.setSelectedTabIndicator(R.drawable.ic_ellipse_1)
        tabLayoutPlayer.setTabTextColors(
            ContextCompat.getColor(this, R.color.unSelectedTextColor),
            ContextCompat.getColor(this, R.color.selectedTextColor)
        )
        //tabLayoutPlayer.pointerIcon

        viewPagerPlayerAdapter.notifyDataSetChanged()

    }
}