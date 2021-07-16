package com.anggarad.dev.foodfinder.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.anggarad.dev.foodfinder.core.data.source.local.entity.RecipeDetailEntity

@Database(
    entities = [RecipeDetailEntity::class],
    version = 1, exportSchema = false
)
@TypeConverters(ListConverters::class)
abstract class RecipeDatabase : RoomDatabase() {

    abstract fun recipeDao(): RecipeDao
}