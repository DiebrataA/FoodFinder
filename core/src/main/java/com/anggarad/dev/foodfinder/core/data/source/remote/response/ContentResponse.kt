package com.anggarad.dev.foodfinder.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ContentResponse(

    @field:SerializedName("ingredientLines")
    val ingredientLines: List<Ingredients>? = null,

    @field:SerializedName("preparationSteps")
    val preparationSteps: List<String>? = null,

    @field:SerializedName("details")
    val details: DetailsResponse,
)

data class Ingredients(

    @field:SerializedName("wholeLine")
    val wholeLine: String
)
