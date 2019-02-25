package br.com.jera.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import br.com.animation.databinding.ItemHomeBinding
import br.com.jera.entities.Projects
import br.com.jera.viewholders.ViewHolderHome

class AdapterHome(private val projects: List<Any?>) :
    RecyclerView.Adapter<ViewHolderHome>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = ViewHolderHome(
        ItemHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount(): Int {
        return projects.size
    }

    override fun onBindViewHolder(holder: ViewHolderHome, position: Int) {
        val element = projects[position]
        holder.format(element as? Projects)
    }
}