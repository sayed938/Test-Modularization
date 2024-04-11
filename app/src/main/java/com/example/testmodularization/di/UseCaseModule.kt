package com.example.testmodularization.di

import com.example.domain.repo.GetMealsRepo
import com.example.domain.usecase.UseCaseMeals
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
@Provides
    fun provideMealsUseCase(getMealsRepo: GetMealsRepo): UseCaseMeals {
        return UseCaseMeals(getMealsRepo)
    }
}