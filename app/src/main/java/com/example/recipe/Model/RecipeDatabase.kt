package com.example.recipe.Model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.recipe.ViewModel.RecipeDao
import com.example.recipe.ViewModel.Recipes

@Database(entities = [Recipes::class, CategoryItems::class, Category::class, Meal::class, MealItems::class], version = 1, exportSchema = false)
@TypeConverters(CategoryListConverter::class, MealListConverter::class)
        abstract class RecipeDatabase: RoomDatabase() {

            companion object {
                var recipeDatabase: RecipeDatabase? = null

                @Synchronized
                fun getDatabase(context: Context): RecipeDatabase {
                    if (recipeDatabase == null) {
                        recipeDatabase = Room.databaseBuilder(
                            context,
                            RecipeDatabase::class.java,
                        "recipe.db"
                        ).build()
                    }
                    return recipeDatabase!!
                }
            }
    abstract fun recipeDao(): RecipeDao
        }