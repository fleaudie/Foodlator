package com.fleaudie.foodlator.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fleaudie.foodlator.R
import com.fleaudie.foodlator.data.FoodItem

class FoodListAdapter(private val foodItemList: List<FoodItem>) :
    RecyclerView.Adapter<FoodListAdapter.FoodItemViewHolder>() {

    class FoodItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtFoodName: TextView = itemView.findViewById(R.id.txtFoodName)
        val txtFoodKcal: TextView = itemView.findViewById(R.id.txtFoodKcal)
        val txtFoodCarbon: TextView = itemView.findViewById(R.id.txtFoodCarbon)
        val txtFoodProtein: TextView = itemView.findViewById(R.id.txtFoodProtein)
        val txtFoodFat: TextView = itemView.findViewById(R.id.txtFoodFat)
        val txtFoodFibre: TextView = itemView.findViewById(R.id.txtFoodFibre)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodItemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_foodlist, parent, false)
        return FoodItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FoodItemViewHolder, position: Int) {
        val foodItem = foodItemList[position]

        holder.txtFoodName.text = foodItem.foodName
        holder.txtFoodKcal.text = "Kcal: ${foodItem.nutrients.calories}"
        holder.txtFoodCarbon.text = "Carbon: ${foodItem.nutrients.carbs}"
        holder.txtFoodProtein.text = "Protein: ${foodItem.nutrients.protein}"
        holder.txtFoodFat.text = "Fat: ${foodItem.nutrients.fat}"
        holder.txtFoodFibre.text = "Fibre: ${foodItem.nutrients.fiber}"
    }

    override fun getItemCount(): Int {
        return foodItemList.size
    }
}
