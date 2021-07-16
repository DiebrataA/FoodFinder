package com.anggarad.dev.foodfinder.core.data.source.remote.network

import com.anggarad.dev.foodfinder.core.data.source.remote.response.ListRecipeResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("feeds/list")
    suspend fun getRecipe(
        @Query("start") start: Int,
        @Query("limit") limit: Int,
        @Query("tag") tag: String
    ): ListRecipeResponse
}