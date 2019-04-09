package br.com.animation.fragments

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import br.com.animation.Activities.LoginActivity
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
        adapter = AdapterHome(Projects.getProjects(), ::showDetails)
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.adapter = adapter
        AnimationUtils.loadLayoutAnimation(activity?.applicationContext, R.anim.animation_recycle_view).run {
            binding.recyclerView.layoutAnimation = this
        }
    }

    private fun showDetails(projects: Projects) {
        Intent(activity, LoginActivity::class.java).run {
            putExtra(PROJECT_NAME, projects.name)
            putExtra(PROJECT_BODY, projects.body)
            startActivity(this)
        }
    }

    companion object {
        const val PROJECT_NAME = "PROJECT_NAME"
        const val PROJECT_BODY = "PROJECT_BODY"
    }
}
