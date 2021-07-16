package com.anggarad.dev.foodfinder.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anggarad.dev.foodfinder.core.R
import com.anggarad.dev.foodfinder.core.databinding.PrepListLayoutBinding

class PrepAdapter : RecyclerView.Adapter<PrepAdapter.PrepViewHolder>() {

    private var listSteps = ArrayList<String>()

    fun setData(newList: List<String>?) {
        if (newList == null) return
        listSteps.clear()
        listSteps.addAll(newList)
        notifyDataSetChanged()
    }

    inner class PrepViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var binding = PrepListLayoutBinding.bind(itemView)
        fun bind(position: Int) {
            binding.numberList.text = "${position + 1}"
            binding.listPrepSteps.text = listSteps[position]
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PrepViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.prep_list_layout, parent, false)
    )

    override fun onBindViewHolder(holder: PrepViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return listSteps.size
    }
}
