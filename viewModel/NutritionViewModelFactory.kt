package com.fleaudie.foodlator.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fleaudie.foodlator.inter.FoodAPIService

class NutritionViewModelFactory(private val apiService: FoodAPIService) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NutritionViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return NutritionViewModel(apiService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}