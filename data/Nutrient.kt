package com.fleaudie.foodlator.data

import com.google.gson.annotations.SerializedName

data class Nutrient(
    @SerializedName("label") val label: String,
    @SerializedName("quantity") val quantity: Double,
    @SerializedName("unit") val unit: String
    // Diğer gerekli alanlar
)
