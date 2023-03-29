package com.example.recipe.ViewModel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recipe.R
import com.example.recipe.databinding.ItRvSubCategoryBinding



class MainCategoryAdapter: RecyclerView.Adapter<MainCategoryAdapter.RecipeViewHolder>() {





    var arrMainCategory = ArrayList<Recipes>()

    class RecipeViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tvDishName: TextView = itemView.findViewById(R.id.tv_dish_name)
    }

    fun setData(arrData: List<Recipes>) {
        arrMainCategory = arrData as ArrayList<Recipes>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        return RecipeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_rv_main_category, parent, false))
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {

        holder.tvDishName.text = arrMainCategory[position].dishname
    }

    override fun getItemCount(): Int {
        return arrMainCategory.size
    }
}