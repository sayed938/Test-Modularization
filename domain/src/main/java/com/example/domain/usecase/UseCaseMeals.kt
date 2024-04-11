package com.example.domain.usecase

import com.example.domain.repo.GetMealsRepo

class UseCaseMeals(private val getMeals: GetMealsRepo) {
    suspend  operator fun invoke() = getMeals.getMealsRemotely()
}