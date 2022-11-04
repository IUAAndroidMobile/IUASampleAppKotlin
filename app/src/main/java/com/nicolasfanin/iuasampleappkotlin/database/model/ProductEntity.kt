package com.nicolasfanin.iuasampleappkotlin.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Product")
data class ProductEntity(
    @PrimaryKey(autoGenerate = true)
    val id : Int? = Math.random().toInt(),
    @ColumnInfo(name = "product_title")
    val title : String,
    val description: String,
    val imageURL : String,
    val price : Double
)
