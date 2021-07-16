package com.anggarad.dev.foodfinder.core.domain.usecase

import com.anggarad.dev.foodfinder.core.data.Resource
import com.anggarad.dev.foodfinder.core.domain.model.RecipeDetail
import kotlinx.coroutines.flow.Flow

interface RecipeUseCase {
    fun getPopularRecipe(): Flow<Resource<List<RecipeDetail>>>
    fun getTrendingRecipe(): Flow<Resource<List<RecipeDetail>>>
    fun getFavoriteRecipe(): Flow<List<RecipeDetail>>
    fun setFavoriteRecipe(recipe: RecipeDetail, state: Boolean)
}