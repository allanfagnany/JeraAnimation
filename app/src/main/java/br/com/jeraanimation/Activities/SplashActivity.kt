package br.com.jeraanimation.Activities

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.AnimationUtils
import br.com.jeraanimation.R
import br.com.jeraanimation.databinding.ActivitySplashBinding
import br.com.jeraanimation.util.scheduleCallback


class SplashActivity : AppCompatActivity() {

    lateinit var binding: ActivitySplashBinding

    companion object {
        private const val DEFAULT_TIME_IN_SEC = 4000L
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        setAnimationImageView()
    }

    private fun setAnimationImageView() {
        AnimationUtils.loadAnimation(applicationContext, R.anim.gravity).apply {
            binding.robotImageView.startAnimation(this)
        }
        scheduleCallback(::goToStart, DEFAULT_TIME_IN_SEC)
    }

    private fun goToStart() {
        Intent(this, TutorialActivity::class.java).apply {
            startActivity(this)
        }
    }
}
