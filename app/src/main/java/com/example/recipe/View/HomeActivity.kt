package com.example.recipe.View

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipe.Model.CategoryItems
import com.example.recipe.Model.RecipeDatabase
import com.example.recipe.ViewModel.MainCategoryAdapter
import com.example.recipe.ViewModel.Recipes
import com.example.recipe.ViewModel.SubCategoryAdapter
import com.example.recipe.databinding.ActivityHomeBinding
import kotlinx.coroutines.launch


class HomeActivity : BaseActivity() {

    private lateinit var binding: ActivityHomeBinding

    var arrMainCategory = ArrayList<CategoryItems>()
    var arrSubCategory = ArrayList<Recipes>()

    var mainCategoryAdapter = MainCategoryAdapter()
    var subCategoryAdapter = SubCategoryAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getDataFromDb()


        arrSubCategory.add(Recipes(1, "Meatloaf"))
        arrSubCategory.add(Recipes(2, "Fried Chicken"))
        arrSubCategory.add(Recipes(3, "Pecan Pie"))
        arrSubCategory.add(Recipes(4, "Fresca"))

        subCategoryAdapter.setData(arrSubCategory)

        binding.rvSubCategory.layoutManager = LinearLayoutManager(this@HomeActivity,
        LinearLayoutManager.HORIZONTAL, false)
        binding.rvSubCategory.adapter = subCategoryAdapter
    }

    private fun getDataFromDb() {
        launch {
            this.let {
                var cat = RecipeDatabase.getDatabase(this@HomeActivity).recipeDao().getAllCategory()
                arrMainCategory = cat as ArrayList<CategoryItems>
                arrMainCategory.reverse()
                mainCategoryAdapter.setData(arrMainCategory)
                binding.rvMainCategory.layoutManager = LinearLayoutManager(this@HomeActivity,
                    LinearLayoutManager.HORIZONTAL, false)
                binding.rvMainCategory.adapter = mainCategoryAdapter
            }
        }
    }
}