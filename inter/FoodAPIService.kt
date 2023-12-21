package com.fleaudie.foodlator.inter

import com.fleaudie.foodlator.data.NutritionResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FoodAPIService {
    @GET("api/nutrition-data")
    suspend fun getNutritionData(
        @Query("app_id") appId: String,
        @Query("app_key") appKey: String,
        @Query("nutrition-type") nutritionType: String,
        @Query("ingr") ingredient: String
    ): Response<NutritionResponse>
}