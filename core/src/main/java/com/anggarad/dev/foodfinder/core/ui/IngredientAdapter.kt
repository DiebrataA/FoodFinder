package com.anggarad.dev.foodfinder.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anggarad.dev.foodfinder.core.R
import com.anggarad.dev.foodfinder.core.databinding.IngredientItemBinding

class IngredientAdapter : RecyclerView.Adapter<IngredientAdapter.PrepViewHolder>() {

    private var listIngredient = ArrayList<String>()

    fun setDataIngredient(newList: List<String>?) {
        if (newList == null) return
        listIngredient.clear()
        listIngredient.addAll(newList)
        notifyDataSetChanged()
    }

    inner class PrepViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var binding = IngredientItemBinding.bind(itemView)
        fun bind(position: Int) {
            binding.ingredientItem.text = listIngredient[position]
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PrepViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.ingredient_item, parent, false)
    )

    override fun onBindViewHolder(holder: PrepViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return listIngredient.size
    }
}
