package br.com.jeraanimation.Activities

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.jeraanimation.R
import br.com.jeraanimation.adapters.TutorialAdapter
import br.com.jeraanimation.databinding.ActivityTutorialBinding

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
