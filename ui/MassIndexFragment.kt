package com.fleaudie.foodlator.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fleaudie.foodlator.R
import com.fleaudie.foodlator.databinding.FragmentFoodListBinding
import com.fleaudie.foodlator.databinding.FragmentMassIndexBinding

class MassIndexFragment : Fragment() {

    private var binding: FragmentMassIndexBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMassIndexBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.imgCalculate?.setOnClickListener {
            calculateBMI()
        }
    }

    private fun calculateBMI() {
        val weightString = binding?.txtWeight?.text.toString()
        val heightString = binding?.txtHeight?.text.toString()
        val ageString = binding?.txtAge?.text.toString()
        val gender = binding?.txtGender?.text.toString()

        if (weightString.isNotEmpty() && heightString.isNotEmpty() && ageString.isNotEmpty()) {
            val weight = weightString.toDouble()
            val height = heightString.toDouble()
            val age = ageString.toInt()

            // BMI Hesaplama Formülü: BMI = weight / (height * height)
            var bmi = weight / (height * height)

            // Yaş ve Cinsiyet faktörleri
            if (age < 18) {
                // Yaş faktörü: 18 yaş altındakilere ek bir işlem uygula (örneğin, az bir miktar BMI ekle)
                bmi += 1.0
            }

            if (gender.equals("female", ignoreCase = true)) {
                // Cinsiyet faktörü: Kadınlara ek bir işlem uygula (örneğin, az bir miktar BMI ekle)
                bmi += 0.5
            }

            // Güncellenen BMI'yi ekrana yazdır
            displayResult(bmi)
        }
    }

    private fun displayResult(bmi: Double) {
        val resultText = when {
            bmi < 18.5 -> "Underweight"
            bmi < 24.9 -> "Normal Weight"
            bmi < 29.9 -> "Overweight"
            else -> "Obese"
        }

        binding?.txtResult?.text = "BMI: $bmi\n$resultText"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}