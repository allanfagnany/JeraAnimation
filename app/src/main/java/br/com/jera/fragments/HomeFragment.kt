package br.com.animation.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import br.com.animation.R
import br.com.animation.databinding.FragmentHomeBinding
import br.com.jera.adapters.AdapterHome
import br.com.jera.entities.Projects

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: AdapterHome

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        setupRecyclerView()
        return binding.root
    }

    private fun setupRecyclerView() {
        adapter = AdapterHome(Projects.getProjects())
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.adapter = adapter
        AnimationUtils.loadLayoutAnimation(activity?.applicationContext, R.anim.animation_recycle_view).run {
            binding.recyclerView.layoutAnimation = this
        }
    }
}
