package com.anggarad.dev.foodfinder.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anggarad.dev.foodfinder.core.R
import com.anggarad.dev.foodfinder.core.databinding.ItemLayoutBinding
import com.anggarad.dev.foodfinder.core.domain.model.RecipeDetail
import com.bumptech.glide.Glide

class RecipeAdapter : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {


    private var listData = ArrayList<RecipeDetail>()
    var onItemClick: ((RecipeDetail) -> Unit)? = null


    fun setData(newList: List<RecipeDetail>?) {
        if (newList == null) return
        listData.clear()
        listData.addAll(newList)
        notifyDataSetChanged()
    }

    inner class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var binding = ItemLayoutBinding.bind(itemView)
        fun bind(itemPopular: RecipeDetail) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(itemPopular.images)
                    .into(ivItemImage)
                tvItemRating.text = itemPopular.rating.toString()
                tvItemTitle.text = itemPopular.name
                tvItemTime.text = itemPopular.totalTime
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        RecipeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        )

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return listData.size
    }


}