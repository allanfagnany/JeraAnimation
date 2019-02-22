package br.com.jeraanimation.Activities

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.AnimationUtils
import br.com.jeraanimation.R
import br.com.jeraanimation.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        animateLayout()
        setClickListeners()
    }

    private fun animateLayout() {
        AnimationUtils.loadAnimation(applicationContext, R.anim.fade_in).apply {
            binding.brandLogo.startAnimation(this)
        }
        AnimationUtils.loadAnimation(applicationContext, R.anim.slide_up_no_bounce).apply {
            binding.emailInput.startAnimation(this)
            binding.passwordInput.startAnimation(this)
        }
        AnimationUtils.loadAnimation(applicationContext, R.anim.slide_right).apply {
            binding.buttonLogin.startAnimation(this)
        }
    }

    private fun setClickListeners() {
        binding.buttonLogin.setOnClickListener { goToMain() }
    }

    private fun goToMain() {
        Intent(this, MainActivity::class.java).apply {
            zoomIn()
            startActivity(this)
        }

    }

    private fun zoomIn() {
        AnimationUtils.loadAnimation(applicationContext, R.anim.zoom_in).apply {
            binding.linearLayoutLogin.startAnimation(this)
        }
    }
}
