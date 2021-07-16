package com.anggarad.dev.foodfinder.di

import com.anggarad.dev.foodfinder.core.domain.usecase.RecipeInteractor
import com.anggarad.dev.foodfinder.core.domain.usecase.RecipeUseCase
import com.anggarad.dev.foodfinder.detail.DetailRecipeViewModel
import com.anggarad.dev.foodfinder.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<RecipeUseCase> { RecipeInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailRecipeViewModel(get())}
}