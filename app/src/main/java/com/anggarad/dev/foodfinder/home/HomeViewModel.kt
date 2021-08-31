package com.anggarad.dev.foodfinder.home


import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.anggarad.dev.foodfinder.core.domain.usecase.RecipeUseCase

class HomeViewModel(recipeUseCase: RecipeUseCase): ViewModel() {
    val popularRecipe = recipeUseCase.getPopularRecipe().asLiveData()
    val trendingRecipe = recipeUseCase.getTrendingRecipe().asLiveData()

}