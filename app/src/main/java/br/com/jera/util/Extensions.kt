package br.com.animation.util

import android.view.View
import java.util.*
import kotlin.concurrent.schedule

fun scheduleCallback(callback: () -> Unit, time: Long) {
    Timer().schedule(time) { callback.invoke() }
}

fun View.setVisibility(visible: Boolean) {
    this.visibility = if(visible) View.VISIBLE else View.GONE
}