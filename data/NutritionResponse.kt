package com.fleaudie.foodlator.data

import com.google.gson.annotations.SerializedName

data class NutritionResponse(
    @SerializedName("totalNutrients") val totalNutrients: Map<String, Nutrient>,
    // Diğer gerekli alanlar
)
