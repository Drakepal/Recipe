package com.example.recipe.ViewModel

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recipe.Model.CategoryItems
import com.example.recipe.R


class MainCategoryAdapter: RecyclerView.Adapter<MainCategoryAdapter.RecipeViewHolder>() {





    var arrMainCategory = ArrayList<CategoryItems>()
    var ctx: Context? = null
    var listener: OnItemClickListener? = null

    class RecipeViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tvDishName: TextView = itemView.findViewById(R.id.tv_dish_name)
        val imgDishName: ImageView = itemView.findViewById(R.id.img_dish)
    }

    fun setData(arrData: ArrayList<CategoryItems>) {
        arrMainCategory = arrData as ArrayList<CategoryItems>
    }

    fun setClickListener(listener1: OnItemClickListener) {
        listener = listener1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        ctx = parent.context
        return RecipeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_rv_main_category, parent, false))
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {

        holder.tvDishName.text = arrMainCategory[position].strcategory
        Glide.with(ctx!!).load(arrMainCategory[position].strcategorythumb).into(holder.imgDishName)
        holder.itemView.rootView.setOnClickListener {
            listener!!.onClicked(arrMainCategory[position].strcategory)
        }
    }

    override fun getItemCount(): Int {
        return arrMainCategory.size
    }

    interface OnItemClickListener {
        fun onClicked(categoryName: String)
    }
}