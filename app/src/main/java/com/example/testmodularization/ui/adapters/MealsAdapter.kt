package com.example.testmodularization.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entity.Category
import com.example.testmodularization.R
import com.squareup.picasso.Picasso

class MealsAdapter(private val mealsList: List<Category>) :
    RecyclerView.Adapter<MealsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View =
            LayoutInflater.from(parent.context).inflate(R.layout.base_custom, parent, false)
        return ViewHolder(v)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val meal = mealsList[position]
        holder.apply {
            insertData(
                meal.strCategory,
                meal.strCategoryDescription,
                meal.strCategoryThumb
            )
        }

    }

    override fun getItemCount(): Int = mealsList.size


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val mealName: TextView = itemView.findViewById(R.id.meal_name)
        private val mealDesc: TextView = itemView.findViewById(R.id.meal_desc)
        private val mealImg: ImageView = itemView.findViewById(R.id.mealImage)

        fun insertData(name: String, desc: String, img: String) {
            mealName.text = name
            mealDesc.text = desc
            Picasso.get().load(img).into(mealImg)
        }
    }
}