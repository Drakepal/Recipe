package com.example.recipe.ViewModel

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.recipe.Model.Category


@Dao
interface RecipeDao {

    @Query("SELECT * FROM category ORDER BY id DESC")
    suspend fun getAllCategory(): List<Category>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(categoryItems: com.example.recipe.Model.CategoryItems)


    @Query("DELETE FROM categoryitems")
    suspend fun clearDb()

}