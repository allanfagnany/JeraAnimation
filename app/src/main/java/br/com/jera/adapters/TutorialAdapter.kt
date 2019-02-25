package br.com.animation.adapters

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import br.com.animation.R
import br.com.animation.fragments.TutorialFragment
import br.com.animation.util.Constants

class TutorialAdapter(private val context: Context, fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> TutorialFragment.getInstance(
                context.getString(R.string.search_title),
                Constants.FIRST_BACKGROUND_INTRO
            )
            1 -> TutorialFragment.getInstance(
                context.getString(R.string.star_body),
                Constants.SECOND_BACKGROUND_INTRO
            )
            2 -> TutorialFragment.getInstance(
                context.getString(R.string.check_body),
                Constants.THIRD_BACKGROUND_INTRO, true
            )
            else -> throw RuntimeException("empty fragment")
        }
    }

    override fun getCount() = 3
}