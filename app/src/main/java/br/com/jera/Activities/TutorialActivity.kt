package br.com.animation.Activities

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.animation.R
import br.com.animation.adapters.TutorialAdapter
import br.com.animation.databinding.ActivityTutorialBinding

class TutorialActivity : AppCompatActivity() {

    lateinit var binding: ActivityTutorialBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tutorial)
        initViewPager()
    }

    private fun initViewPager() {
        binding.dotsTabLayout.setupWithViewPager(binding.tutorialViewPager)
        binding.tutorialViewPager.adapter = TutorialAdapter(this, supportFragmentManager)
    }
}
