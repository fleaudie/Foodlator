package com.fleaudie.foodlator.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fleaudie.foodlator.data.NutritionResponse
import com.fleaudie.foodlator.inter.FoodAPIService
import com.fleaudie.foodlator.repository.NutritionRepository
import kotlinx.coroutines.launch

class NutritionViewModel(private val apiService: FoodAPIService) : ViewModel() {

    private val repository: NutritionRepository = NutritionRepository(apiService)

    private val _nutritionData = MutableLiveData<NutritionResponse?>()
    val nutritionData: LiveData<NutritionResponse?> = _nutritionData

    fun fetchNutritionData(appId: String, appKey: String, nutritionType: String, ingredient: String) {
        viewModelScope.launch {
            try {
                val data = repository.getNutritionData(appId, appKey, nutritionType, ingredient)
                _nutritionData.value = data
            } catch (e: Exception) {
                Log.e("APIResponse", "API çağrısında hata oluştu", e)
            }
        }
    }
}