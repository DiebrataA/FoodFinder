package com.anggarad.dev.foodfinder.core.domain.repository

import com.anggarad.dev.foodfinder.core.data.Resource
import com.anggarad.dev.foodfinder.core.domain.model.RecipeDetail
import kotlinx.coroutines.flow.Flow

interface IRecipeRepository {

    fun getPopularRecipe(): Flow<Resource<List<RecipeDetail>>>

    fun getTrendingRecipe(): Flow<Resource<List<RecipeDetail>>>

    fun getFavoriteRecipe(): Flow<List<RecipeDetail>>

    fun setFavoriteRecipe(recipe: RecipeDetail, state: Boolean)
}