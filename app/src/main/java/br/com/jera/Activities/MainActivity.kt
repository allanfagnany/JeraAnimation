package br.com.animation.Activities

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.animation.AnimationUtils
import br.com.animation.R
import br.com.animation.databinding.ActivityMainBinding
import br.com.animation.fragments.DashboardFragment
import br.com.animation.fragments.HomeFragment
import br.com.animation.fragments.ProfileFragment
import br.com.animation.util.FragmentType

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener{

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.navigation.setOnNavigationItemSelectedListener(this)
        setAnimationNavigation()
        changeFragment(FragmentType.HOME)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.navigation_home -> changeFragment(FragmentType.HOME)
            R.id.navigation_dashboard -> changeFragment(FragmentType.DASHBOARD)
            R.id.navigation_profile -> changeFragment(FragmentType.NOTIFICATION)
        }
        return true
    }

    private fun setAnimationNavigation() {
        AnimationUtils.loadAnimation(applicationContext, R.anim.slide_up).run {
            binding.navigation.startAnimation(this)
        }
    }

    private fun changeFragment(tag: FragmentType) {
        val baseFragment = getFragmentForTag(tag)
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
            .replace(R.id.fragment_container, baseFragment, tag.name)
            .commit()
    }

    private fun getFragmentForTag(tag: FragmentType): Fragment {
        return when (tag) {
            FragmentType.HOME -> HomeFragment()
            FragmentType.DASHBOARD -> DashboardFragment()
            FragmentType.NOTIFICATION -> ProfileFragment()
        }
    }
}
