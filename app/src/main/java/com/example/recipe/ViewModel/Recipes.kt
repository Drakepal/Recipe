package com.example.recipe.ViewModel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "Recipes")
data class Recipes (
    @PrimaryKey(autoGenerate = true)
    var id: Int,

    @ColumnInfo(name = "dishname")
    var  dishname: String

) : Serializable