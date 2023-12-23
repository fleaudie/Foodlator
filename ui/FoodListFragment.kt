package com.fleaudie.foodlator.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.fleaudie.foodlator.adapter.FoodListAdapter
import com.fleaudie.foodlator.data.FoodItem
import com.fleaudie.foodlator.databinding.FragmentFoodListBinding

class FoodListFragment : Fragment() {

    private var binding: FragmentFoodListBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFoodListBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val foodItemList: List<FoodItem> =
            arguments?.getParcelableArrayList("foodList") ?: emptyList()

        setupRecyclerView(foodItemList)
    }

    private fun setupRecyclerView(foodItemList: List<FoodItem>) {
        val recyclerView = binding?.rcyFoodList

        val layoutManager = LinearLayoutManager(requireContext())
        recyclerView?.layoutManager = layoutManager

        val adapter = FoodListAdapter(foodItemList)
        recyclerView?.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
