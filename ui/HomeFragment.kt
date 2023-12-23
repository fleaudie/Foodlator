package com.fleaudie.foodlator.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.fleaudie.foodlator.APIHelper
import com.fleaudie.foodlator.R
import com.fleaudie.foodlator.data.FoodItem
import com.fleaudie.foodlator.data.Nutrients
import com.fleaudie.foodlator.databinding.FragmentHomeBinding
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class HomeFragment : Fragment() {

    private var binding : FragmentHomeBinding? = null
    lateinit var navController: NavController
    private val apiHelper = APIHelper()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (viewLifecycleOwner != null) {
            navController = findNavController() // NavController'ı başlat
        }

        binding?.imgCatFruits?.setOnClickListener {
            getCategoryInfo("fruit_and_vegetables")
        }
        binding?.imgCatProtein?.setOnClickListener {
            getCategoryInfo("proteins")
        }
        binding?.imgCatDairy?.setOnClickListener {
            getCategoryInfo("dairy")
        }
        binding?.imgCatGrains?.setOnClickListener {
            getCategoryInfo("grains_and_legumes")
        }
        binding?.imgCatFats?.setOnClickListener {
            getCategoryInfo("fats_and_nuts")
        }
        binding?.imgCatBeverages?.setOnClickListener {
            getCategoryInfo("beverages")
        }
        binding?.imgCatSnacks?.setOnClickListener {
            getCategoryInfo("snacks")
        }

        binding?.imgGoCalculate?.setOnClickListener {
            navController.navigate(R.id.action_homeFragment_to_massIndexFragment)
        }
    }

    private fun getCategoryInfo(categoryName: String) {
        apiHelper.getCategoryInfo(categoryName) { responseData ->
            activity?.runOnUiThread {
                if (responseData != null) {
                    try {
                        val foodItemList = mutableListOf<FoodItem>()

                        // JSON verisini işleyin
                        val jsonArray = JSONArray(responseData)

                        // JSON dizisinde döngü
                        for (i in 0 until jsonArray.length()) {
                            val jsonObject = jsonArray.getJSONObject(i)
                            val foodName = jsonObject.optString("food", "Unknown Food")

                            // Diğer veri işlemlerini burada yapabilirsiniz
                            val nutrientsJsonObject = jsonObject.optJSONObject("nutrients")
                            val nutrients = Nutrients(
                                carbs = nutrientsJsonObject.optDouble("CHOCDF"),
                                calories = nutrientsJsonObject.optInt("ENERC_KCAL"),
                                fat = nutrientsJsonObject.optDouble("FAT"),
                                fiber = nutrientsJsonObject.optDouble("FIBTG"),
                                protein = nutrientsJsonObject.optDouble("PROCNT")
                            )

                            // FoodItem oluşturup listeye ekle
                            val foodItem = FoodItem(foodName, nutrients)
                            foodItemList.add(foodItem)
                        }

                        // Yiyecek listesini başka bir fragment'e geçir
                        navigateToFoodListFragment(foodItemList)

                    } catch (e: JSONException) {
                        // JSON verisini işlerken hata oluştu
                        e.printStackTrace()
                        Toast.makeText(requireContext(), "Error processing JSON data", Toast.LENGTH_SHORT).show()
                    }

                } else {
                    Toast.makeText(requireContext(), "Error fetching data", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun navigateToFoodListFragment(foodItemList: List<FoodItem>) {
        val bundle = Bundle()
        bundle.putParcelableArrayList("foodList", ArrayList(foodItemList))
        navController.navigate(R.id.action_homeFragment_to_foodListFragment, bundle)
    }

}