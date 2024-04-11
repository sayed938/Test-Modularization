package com.example.data.repo

import com.example.data.remote.MealsApiServices
import com.example.domain.entity.MealModel
import com.example.domain.repo.GetMealsRepo

class MealsRepoImpl(private val getMealFromApi: MealsApiServices) : GetMealsRepo {
    override suspend fun getMealsRemotely(): MealModel = getMealFromApi.getMealsFromApi()
}