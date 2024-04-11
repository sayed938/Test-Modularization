package com.example.testmodularization.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testmodularization.ui.adapters.MealsAdapter
import com.example.testmodularization.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MealsViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterMeals: MealsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rcMeals.setLayoutManager(LinearLayoutManager(applicationContext))
        lifecycleScope.launch {
            viewModel.mealStateFlow.collect {
                withContext(Dispatchers.Main) {
                    try {
                        adapterMeals = MealsAdapter(it!!.categories)
                        binding.rcMeals.adapter = adapterMeals
                    } catch (e: Exception) {
                        Log.d("DataErrorSayed", e.message.toString())
                    }
                }

            }
        }
    }
}