package com.anggarad.dev.foodfinder.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListRecipeResponse(
    @field:SerializedName("feed")
    val feed: List<Feed>,
)

data class Feed(

    @field:SerializedName("content")
    val content: ContentResponse,

)
