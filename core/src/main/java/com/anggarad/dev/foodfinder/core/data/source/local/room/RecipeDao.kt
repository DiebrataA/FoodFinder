package com.anggarad.dev.foodfinder.core.data.source.local.room

import androidx.room.*
import com.anggarad.dev.foodfinder.core.data.source.local.entity.RecipeDetailEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao {

    @Query("SELECT * FROM recipe")
    fun getAllRecipe(): Flow<List<RecipeDetailEntity>>

    @Query("SELECT * FROM recipe where isFavorite = 1")
    fun getFavoriteRecipe(): Flow<List<RecipeDetailEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipe(recipe: List<RecipeDetailEntity>)

    @Update
    fun updateFavoriteRecipe(recipe: RecipeDetailEntity)
}