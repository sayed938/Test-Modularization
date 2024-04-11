package com.example.testmodularization.di

import com.example.data.remote.MealsApiServices
import com.example.data.repo.MealsRepoImpl
import com.example.domain.repo.GetMealsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {
    @Provides
    fun provideMealsRepo(apiServices: MealsApiServices): GetMealsRepo {
        return MealsRepoImpl(apiServices)
    }
}