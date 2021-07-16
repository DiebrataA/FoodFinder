package com.anggarad.dev.foodfinder.core.data.source.local

import com.anggarad.dev.foodfinder.core.data.source.local.entity.RecipeDetailEntity
import com.anggarad.dev.foodfinder.core.data.source.local.room.RecipeDao
import kotlinx.coroutines.flow.Flow


class LocalDataSource(private val recipeDao: RecipeDao) {

    fun getAllRecipe(): Flow<List<RecipeDetailEntity>> = recipeDao.getAllRecipe()

    fun getFavoriteRecipe(): Flow<List<RecipeDetailEntity>> = recipeDao.getFavoriteRecipe()

    suspend fun insertRecipe(recipeList: List<RecipeDetailEntity>) =
        recipeDao.insertRecipe(recipeList)

    fun setFavoriteRecipe(recipe: RecipeDetailEntity, newState: Boolean) {
        recipe.isFavorite = newState
        recipeDao.updateFavoriteRecipe(recipe)
    }
}