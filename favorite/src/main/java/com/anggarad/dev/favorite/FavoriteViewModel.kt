package com.anggarad.dev.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.anggarad.dev.foodfinder.core.domain.usecase.RecipeUseCase

class FavoriteViewModel(recipeUseCase: RecipeUseCase) : ViewModel() {
    val favoriteRecipe = recipeUseCase.getFavoriteRecipe().asLiveData()
}