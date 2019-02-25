package br.com.animation.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.animation.databinding.FragmentNotificationBinding

class NotificationFragment : Fragment() {

    lateinit var binding: FragmentNotificationBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentNotificationBinding.inflate(inflater, container, false)
        return binding.root
    }
}
