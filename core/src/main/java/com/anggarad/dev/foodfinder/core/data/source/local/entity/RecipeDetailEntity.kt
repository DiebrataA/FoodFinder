package com.anggarad.dev.foodfinder.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.*

@Entity(tableName = "recipe")
data class RecipeDetailEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "recipeId")
    val id: String,

    @ColumnInfo(name = "totalTime")
    val totalTime: String,

    @ColumnInfo(name = "images")
    val images: String,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "numberOfServings")
    val numberOfServings: Int,

    @ColumnInfo(name = "rating")
    val rating: Double,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false,

    @ColumnInfo(name = "preparationSteps")
    val preparationSteps: List<String>? = null,

    @ColumnInfo(name = "ingredients")
    val ingredients: List<String>? = null
)
