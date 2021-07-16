package com.anggarad.dev.foodfinder.core.data.source

import android.util.Log
import com.anggarad.dev.foodfinder.core.data.source.remote.network.ApiResponse
import com.anggarad.dev.foodfinder.core.data.source.remote.network.ApiService
import com.anggarad.dev.foodfinder.core.data.source.remote.response.Feed
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class RemoteDataSource(private val apiService: ApiService) {

    suspend fun getPopularRecipe(): Flow<ApiResponse<List<Feed>>> {
        return flow {
            try {
                val response = apiService.getRecipe(0, 18, "list.recipe.popular")
                val dataArray = response.feed
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.feed))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getTrendingRecipe(): Flow<ApiResponse<List<Feed>>> {
        return flow {
            try {
                val response = apiService.getRecipe(0, 18, "list.recipe.trending")
                val dataArray = response.feed
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.feed))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}