package br.com.jera.viewholders

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import br.com.animation.databinding.ItemHomeBinding
import br.com.jera.entities.Projects

class ViewHolderHome(private val binding: ItemHomeBinding) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun inflate(parent: ViewGroup?) =
            ViewHolderHome(ItemHomeBinding.inflate(LayoutInflater.from(parent?.context), parent, false))
    }

    fun format(project: Projects, action: ((Projects) -> Unit?)? = null) {
        binding.root.setOnClickListener { action?.invoke(project) }
        binding.project.text = project.name
        binding.body.text = project.body
    }
}