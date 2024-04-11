package com.example.testmodularization.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.MealModel
import com.example.domain.usecase.UseCaseMeals
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealsViewModel @Inject constructor(
    val useCaseMeals: UseCaseMeals
) : ViewModel() {
    init {
        getMealsVM()
    }

    private val _mealsStateFlow: MutableStateFlow<MealModel?> = MutableStateFlow(null)
    val mealStateFlow: StateFlow<MealModel?> = _mealsStateFlow
    private fun getMealsVM() {
        viewModelScope.launch(Dispatchers.Main) {
            try {
                _mealsStateFlow.value = useCaseMeals()
            } catch (e: Exception) {
                Log.d("vmError", e.message.toString())
            }
        }
    }
}