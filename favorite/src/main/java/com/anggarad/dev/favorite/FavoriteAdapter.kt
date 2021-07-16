package com.anggarad.dev.favorite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anggarad.dev.favorite.databinding.ItemLayoutTrendBinding
import com.anggarad.dev.foodfinder.core.domain.model.RecipeDetail
import com.bumptech.glide.Glide

class FavoriteAdapter : RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {

    private var listFavorite = ArrayList<RecipeDetail>()
    var onItemClick: ((RecipeDetail) -> Unit)? = null

    fun setFavoriteList(newList: List<RecipeDetail>?) {
        if (newList == null) return
        listFavorite.clear()
        listFavorite.addAll(newList)
        notifyDataSetChanged()
    }

    inner class FavoriteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemLayoutTrendBinding.bind(itemView)
        fun bind(data: RecipeDetail) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(data.images)
                    .into(ivItemTrend)
                trendingRecipeTitle.text = data.name
                trendingCookTime.text = data.totalTime
                trendingReview.text = data.rating.toString()
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listFavorite[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        FavoriteViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout_trend, parent, false)
        )


    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val data = listFavorite[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return listFavorite.size
    }
}