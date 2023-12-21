package com.fleaudie.foodlator.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.fleaudie.foodlator.data.NutritionResponse
import com.fleaudie.foodlator.databinding.FragmentBlankBinding
import com.fleaudie.foodlator.inter.FoodAPIService
import com.fleaudie.foodlator.viewModel.NutritionViewModel
import com.fleaudie.foodlator.viewModel.NutritionViewModelFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NutritionFragment : Fragment() {

    private var binding: FragmentBlankBinding? = null
    private lateinit var viewModel: NutritionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlankBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val apiService = Retrofit.Builder()
            .baseUrl("https://api.edamam.com")
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().addInterceptor(loggingInterceptor).build())
            .build()
            .create(FoodAPIService::class.java)

        viewModel = ViewModelProvider(this, NutritionViewModelFactory(apiService))
            .get(NutritionViewModel::class.java)
        val appId = "5e77d529"
        val appKey = "b787916d4e897745fa6465aa414e2c8d"
        val nutritionType = "logging"
        val ingredient = "apple"

        viewModel.fetchNutritionData(appId, appKey, nutritionType, ingredient)

        // LiveData'ı gözlemle ve arayüzü güncelle
        viewModel.nutritionData.observe(viewLifecycleOwner, Observer { nutritionData ->
            // Besin verilerini kullanarak arayüzü güncelle
            updateUI(nutritionData)
        })
    }

    private fun updateUI(nutritionData: NutritionResponse?) {
        if (nutritionData != null) {
            // Besin verilerini işle ve bir metin oluştur
            val nutrientText = buildNutrientText(nutritionData)

            // TextView'e metni ayarla
            val nutritionTextView = binding?.txtBlank
            nutritionTextView?.text = nutrientText
        } else {
            // API çağrısında hata oluştuğunda veya veri alınamadığında bir hata mesajı gösterilebilir
            Log.d("APIResponse", "Hata oluştu")
        }
    }

    private fun buildNutrientText(nutritionData: NutritionResponse): String {
        val nutrientStringBuilder = StringBuilder()

        // İlgili besin değerlerini belirleyin
        val nutrientsOfInterest = listOf("ENERC_KCAL", "CHOCDF", "PROCNT", "FAT")

        for (nutrientLabel in nutrientsOfInterest) {
            val nutrient = nutritionData.totalNutrients[nutrientLabel]
            nutrient?.let {
                val nutrientLine = "${it.label}: ${it.quantity} ${it.unit}\n"
                nutrientStringBuilder.append(nutrientLine)
            }
        }

        return nutrientStringBuilder.toString()
    }

}
