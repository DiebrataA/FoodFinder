package com.anggarad.dev.foodfinder.detail

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.anggarad.dev.foodfinder.core.domain.model.RecipeDetail
import com.anggarad.dev.foodfinder.core.ui.IngredientAdapter
import com.anggarad.dev.foodfinder.core.ui.PrepAdapter
import com.anggarad.dev.foodfinder.databinding.ActivityDetailRecipeBinding
import com.bumptech.glide.Glide
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailRecipeActivity : AppCompatActivity() {

    private val detailViewModel: DetailRecipeViewModel by viewModel()
    private lateinit var binding: ActivityDetailRecipeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val detailRecipe = intent.getParcelableExtra<RecipeDetail>(EXTRA_DATA)

        showDetailRecipe(detailRecipe)
    }

    private fun showDetailRecipe(detailRecipe: RecipeDetail?) {
        detailRecipe?.let {
            supportActionBar?.title = detailRecipe.name
            Glide.with(this@DetailRecipeActivity)
                .load(detailRecipe.images)
                .into(binding.ivDetailImage)

            var favStatus = detailRecipe.isFavorite
            setFavoriteStatus(favStatus)
            binding.fab.setOnClickListener {
                favStatus = !favStatus
                detailViewModel.setFavoriteRecipe(detailRecipe, favStatus)
                setFavoriteStatus(favStatus)
            }
            val prepAdapter = PrepAdapter()
            val ingredientAdapter = IngredientAdapter()
            prepAdapter.setData(detailRecipe.preparationSteps)
            ingredientAdapter.setDataIngredient(detailRecipe.ingredients)
            with(binding.content.listIngredients){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = ingredientAdapter
            }
            with(binding.content.listSteps) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = prepAdapter
            }
        }


    }

    private fun setFavoriteStatus(favStatus: Boolean) {
        if (favStatus) {
            binding.fab.imageTintList = ColorStateList.valueOf(Color.rgb(255, 50, 50))

        } else {
            binding.fab.imageTintList = ColorStateList.valueOf(Color.rgb(255, 255, 255))

        }
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}