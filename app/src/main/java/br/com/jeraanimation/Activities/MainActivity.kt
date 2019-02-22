package br.com.jeraanimation.Activities

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.animation.AnimationUtils
import br.com.jeraanimation.R
import br.com.jeraanimation.databinding.ActivityMainBinding
import br.com.jeraanimation.fragments.DashboardFragment
import br.com.jeraanimation.fragments.HomeFragment
import br.com.jeraanimation.fragments.NotificationFragment
import br.com.jeraanimation.util.FragmentType

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener,
    BottomNavigationView.OnNavigationItemReselectedListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.navigation.setOnNavigationItemSelectedListener(this)
        setAnimationNavigation()
        changeFragment(FragmentType.HOME)
    }

    private fun setAnimationNavigation() {
        AnimationUtils.loadAnimation(applicationContext, R.anim.slide_up).apply {
            binding.navigation.startAnimation(this)
        }
    }

    private fun changeFragment(tag: FragmentType) {
        val baseFragment = getFragmentForTag(tag)
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
            .replace(R.id.fragment_container, baseFragment, tag.name)
            .addToBackStack(FragmentType.HOME.name)
            .commit()
    }

    private fun getFragmentForTag(tag: FragmentType): Fragment {
        return when (tag) {
            FragmentType.HOME -> HomeFragment()
            FragmentType.DASHBOARD -> DashboardFragment()
            FragmentType.NOTIFICATION -> NotificationFragment()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.navigation_home -> changeFragment(FragmentType.HOME)
            R.id.navigation_dashboard -> changeFragment(FragmentType.DASHBOARD)
            R.id.navigation_notifications -> changeFragment(FragmentType.NOTIFICATION)
        }
        return true
    }

    override fun onNavigationItemReselected(p0: MenuItem) {/* TODO */ }
}
