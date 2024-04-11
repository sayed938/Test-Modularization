package com.example.domain.repo

import com.example.domain.entity.MealModel

interface GetMealsRepo {
    suspend fun getMealsRemotely(): MealModel
}