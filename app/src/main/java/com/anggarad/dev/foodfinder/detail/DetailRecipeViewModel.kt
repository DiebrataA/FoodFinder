package com.anggarad.dev.foodfinder.detail

import androidx.lifecycle.ViewModel
import com.anggarad.dev.foodfinder.core.domain.model.RecipeDetail
import com.anggarad.dev.foodfinder.core.domain.usecase.RecipeUseCase

class DetailRecipeViewModel(private val recipeUseCase: RecipeUseCase) : ViewModel() {
    fun setFavoriteRecipe(recipe: RecipeDetail, newStatus: Boolean) =
        recipeUseCase.setFavoriteRecipe(recipe, newStatus)
}