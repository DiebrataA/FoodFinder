package com.anggarad.dev.foodfinder.core.utils

import com.anggarad.dev.foodfinder.core.data.source.local.entity.RecipeDetailEntity
import com.anggarad.dev.foodfinder.core.data.source.remote.response.Feed
import com.anggarad.dev.foodfinder.core.domain.model.RecipeDetail

object DataMapper {

    fun mapFeedResponseToEntities(input: List<Feed>): List<RecipeDetailEntity> {
        val recipeList = ArrayList<RecipeDetailEntity>()
        input.map {
            val ingredient = it.content.ingredientLines?.map { ingredient ->
                ingredient.wholeLine
            }
            val feed = RecipeDetailEntity(
                preparationSteps = it.content.preparationSteps,
                totalTime = it.content.details.totalTime,
                name = it.content.details.name,
                id = it.content.details.id,
                numberOfServings = it.content.details.numberOfServings,
                rating = it.content.details.rating,
                images = it.content.details.images[0].resizableImageUrl,
                isFavorite = false,
                ingredients = ingredient
            )
            recipeList.add(feed)
        }
        return recipeList
    }


    fun mapEntitiesToDomain(input: List<RecipeDetailEntity>): List<RecipeDetail> =
        input.map {
            RecipeDetail(
                totalTime = it.totalTime,
                name = it.name,
                id = it.id,
                images = it.images,
                numberOfServings = it.numberOfServings,
                rating = it.rating,
                isFavorite = it.isFavorite,
                preparationSteps = it.preparationSteps,
                ingredients = it.ingredients

            )
        }


    fun mapDomainToEntity(input: RecipeDetail) = RecipeDetailEntity(
        totalTime = input.totalTime,
        name = input.name,
        id = input.id,
        images = input.images,
        numberOfServings = input.numberOfServings,
        rating = input.rating,
        isFavorite = input.isFavorite,
        preparationSteps = input.preparationSteps,
        ingredients = input.ingredients
    )
}