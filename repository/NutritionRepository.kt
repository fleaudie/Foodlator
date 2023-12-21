package com.fleaudie.foodlator.repository

import android.util.Log
import com.fleaudie.foodlator.data.NutritionResponse
import com.fleaudie.foodlator.inter.FoodAPIService
import java.io.IOException

class NutritionRepository(private val apiService: FoodAPIService) {

    suspend fun getNutritionData(appId: String, appKey: String, nutritionType: String, ingredient: String): NutritionResponse {
        try {
            val response = apiService.getNutritionData(appId, appKey, nutritionType, ingredient)
            if (response.isSuccessful) {
                return response.body()!!
            } else {
                val errorBody = response.errorBody()?.string()
                Log.e("APIResponse", "Error: ${response.code()}, Body: $errorBody")
                // Hata durumunda bir şeyler yapabilirsiniz.
                throw ApiException("API error: ${errorBody ?: "Unknown error"}")
            }
        } catch (e: IOException) {
            Log.e("APIResponse", "IOException: ${e.message}")
            // Hata durumunda bir şeyler yapabilirsiniz.
            throw ApiException("Network error: ${e.message}")
        } catch (e: Exception) {
            Log.e("APIResponse", "Exception: ${e.message}")
            // Hata durumunda bir şeyler yapabilirsiniz.
            throw ApiException("Unknown error: ${e.message}")
        }
    }
}

class ApiException(message: String) : RuntimeException(message)
