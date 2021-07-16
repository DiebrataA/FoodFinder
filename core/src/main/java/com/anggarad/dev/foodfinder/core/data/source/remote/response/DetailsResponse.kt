package com.anggarad.dev.foodfinder.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class DetailsResponse(

    @field:SerializedName("totalTime")
    val totalTime: String,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("images")
    val images: List<ImagesClass>,

    @field:SerializedName("id")
    val id: String,

    @field:SerializedName("numberOfServings")
    val numberOfServings: Int,

    @field:SerializedName("rating")
    val rating: Double
)

data class ImagesClass(
    @field:SerializedName("resizableImageUrl")
    val resizableImageUrl: String
)
