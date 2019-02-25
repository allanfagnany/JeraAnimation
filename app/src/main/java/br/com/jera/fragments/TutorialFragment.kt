package br.com.animation.fragments

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK
import android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.animation.Activities.LoginActivity
import br.com.animation.databinding.FragmentTutorialBinding
import br.com.animation.util.Constants
import br.com.animation.util.setVisibility

class TutorialFragment : Fragment() {

    lateinit var binding: FragmentTutorialBinding

    companion object {
        private const val BACKGROUND_EXTRA = "BACKGROUND_EXTRA"
        private const val TITLE_EXTRA = "TITLE_EXTRA"
        private const val LAST_FRAGMENT_EXTRA = "LAST_FRAGMENT_EXTRA"

        fun getInstance(title: String, background: String, last: Boolean = false): TutorialFragment {
            val fragment = TutorialFragment()
            Bundle().apply {
                this.putString(TITLE_EXTRA, title)
                this.putString(BACKGROUND_EXTRA, background)
                this.putBoolean(LAST_FRAGMENT_EXTRA, last)
                fragment.arguments = this
            }
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentTutorialBinding.inflate(inflater, container, false)
        setupView()
        setupClickListeners()
        return binding.root
    }

    private fun setupClickListeners() {
        binding.nextButton.setOnClickListener {
            Intent(context, LoginActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or FLAG_ACTIVITY_CLEAR_TASK or FLAG_ACTIVITY_SINGLE_TOP)
                startActivity(this)
            }
        }
    }

    private fun setupView() {
        arguments?.apply {
            binding.title.text = getString(TITLE_EXTRA)
            binding.nextButton.setVisibility(getBoolean(LAST_FRAGMENT_EXTRA))
            when (getString(BACKGROUND_EXTRA)) {
                Constants.FIRST_BACKGROUND_INTRO -> binding.animationView.setAnimation("search.json")
                Constants.SECOND_BACKGROUND_INTRO -> binding.animationView.setAnimation("star.json")
                Constants.THIRD_BACKGROUND_INTRO -> binding.animationView.setAnimation("check.json")
                else -> throw RuntimeException("Drawable not found")
            }
        }

    }
}