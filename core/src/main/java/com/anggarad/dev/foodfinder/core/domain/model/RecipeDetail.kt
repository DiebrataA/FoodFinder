package com.anggarad.dev.foodfinder.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RecipeDetail(
    val totalTime: String,
    val name: String,
    val id: String,
    val images: String,
    val numberOfServings: Int,
    val rating: Double,
    var isFavorite: Boolean,
    val preparationSteps: List<String>? = null,
    val ingredients: List<String>? = null
):Parcelable