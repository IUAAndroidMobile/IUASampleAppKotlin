package com.nicolasfanin.iuasampleappkotlin.database.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertProduct(productEntity: ProductEntity)

    @Query("SELECT * from Product")
    fun getAllProducts(): List<ProductEntity>

    @Query("SELECT * FROM Product WHERE id = :id")
    fun getProductById(id: Int): ProductEntity

    @Delete
    fun deleteProduct(productEntity: ProductEntity)

    @Update
    fun updateProduct(productEntity: ProductEntity)

}