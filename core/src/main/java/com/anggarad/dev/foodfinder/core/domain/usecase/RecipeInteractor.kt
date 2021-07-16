package com.anggarad.dev.foodfinder.core.domain.usecase

import com.anggarad.dev.foodfinder.core.data.Resource
import com.anggarad.dev.foodfinder.core.domain.model.RecipeDetail
import com.anggarad.dev.foodfinder.core.domain.repository.IRecipeRepository
import kotlinx.coroutines.flow.Flow

class RecipeInteractor(private val recipeRepository: IRecipeRepository) :
    RecipeUseCase {
    override fun getPopularRecipe(): Flow<Resource<List<RecipeDetail>>> {
        return recipeRepository.getPopularRecipe()
    }

    override fun getTrendingRecipe(): Flow<Resource<List<RecipeDetail>>> {
        return recipeRepository.getTrendingRecipe()
    }

    override fun getFavoriteRecipe(): Flow<List<RecipeDetail>> {
        return recipeRepository.getFavoriteRecipe()
    }

    override fun setFavoriteRecipe(recipe: RecipeDetail, state: Boolean) {
        return recipeRepository.setFavoriteRecipe(recipe, state)
    }

}