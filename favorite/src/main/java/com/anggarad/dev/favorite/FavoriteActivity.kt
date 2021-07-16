package com.anggarad.dev.favorite

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.anggarad.dev.favorite.databinding.ActivityFavoriteBinding
import com.anggarad.dev.foodfinder.detail.DetailRecipeActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class FavoriteActivity : AppCompatActivity() {

    private val favoriteViewModel: FavoriteViewModel by viewModel()
    private lateinit var binding: ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadKoinModules(favModule)

        supportActionBar?.title = "Favorite Recipe"

        showFavoriteList()
    }

    private fun showFavoriteList() {
        val favoriteAdapter = FavoriteAdapter()
        favoriteAdapter.onItemClick = {
            val intent = Intent(this, DetailRecipeActivity::class.java)
            intent.putExtra(DetailRecipeActivity.EXTRA_DATA, it)
            startActivity(intent)
        }

        favoriteViewModel.favoriteRecipe.observe(this, { dataRecipe ->
            favoriteAdapter.setFavoriteList(dataRecipe)
            binding.viewEmpty.root.visibility =
                if (dataRecipe.isNotEmpty()) View.GONE else View.VISIBLE
        })

        with(binding.rvFavorite) {
            layoutManager = GridLayoutManager(context, 2)
            setHasFixedSize(true)
            adapter = favoriteAdapter
        }
    }
}