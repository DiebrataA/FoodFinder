package com.anggarad.dev.foodfinder.core.data

import com.anggarad.dev.foodfinder.core.data.source.RemoteDataSource
import com.anggarad.dev.foodfinder.core.data.source.local.LocalDataSource
import com.anggarad.dev.foodfinder.core.data.source.remote.network.ApiResponse
import com.anggarad.dev.foodfinder.core.data.source.remote.response.Feed
import com.anggarad.dev.foodfinder.core.domain.model.RecipeDetail
import com.anggarad.dev.foodfinder.core.domain.repository.IRecipeRepository
import com.anggarad.dev.foodfinder.core.utils.AppExecutors
import com.anggarad.dev.foodfinder.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RecipeRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IRecipeRepository {
    override fun getPopularRecipe(): Flow<Resource<List<RecipeDetail>>> =
        object : NetworkBoundResource<List<RecipeDetail>, List<Feed>>() {
            override fun loadFromDB(): Flow<List<RecipeDetail>> {
                return localDataSource.getAllRecipe().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<RecipeDetail>?): Boolean =
                data == null || data.isEmpty()


            override suspend fun createCall(): Flow<ApiResponse<List<Feed>>> =
                remoteDataSource.getPopularRecipe()


            override suspend fun saveCallResult(data: List<Feed>) {
                val recipeList = DataMapper.mapFeedResponseToEntities(data)
                localDataSource.insertRecipe(recipeList)
            }

        }.asFlow()

    override fun getTrendingRecipe(): Flow<Resource<List<RecipeDetail>>> =
        object : NetworkBoundResource<List<RecipeDetail>, List<Feed>>() {
            override fun loadFromDB(): Flow<List<RecipeDetail>> {
                return localDataSource.getAllRecipe().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<RecipeDetail>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<Feed>>> =
                remoteDataSource.getTrendingRecipe()

            override suspend fun saveCallResult(data: List<Feed>) {
                val recipeList = DataMapper.mapFeedResponseToEntities(data)
                localDataSource.insertRecipe(recipeList)
            }

        }.asFlow()

    override fun getFavoriteRecipe(): Flow<List<RecipeDetail>> {
        return localDataSource.getFavoriteRecipe().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteRecipe(recipe: RecipeDetail, state: Boolean) {
        val recipeEntity = DataMapper.mapDomainToEntity(recipe)
        appExecutors.diskIO().execute { localDataSource.setFavoriteRecipe(recipeEntity, state) }
    }
}