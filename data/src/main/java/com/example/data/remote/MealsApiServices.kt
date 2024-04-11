package com.example.data.remote

import com.example.domain.entity.MealModel
import retrofit2.http.GET

interface MealsApiServices {
@GET("categories.php")
suspend fun getMealsFromApi(): MealModel

}