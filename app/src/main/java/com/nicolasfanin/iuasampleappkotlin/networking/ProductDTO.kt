package com.nicolasfanin.iuasampleappkotlin.networking

import com.google.gson.annotations.SerializedName

data class ProductListDTO(
    @SerializedName("productList") val listaProductos: List<ProductDTO>
)

data class ProductDTO(
    @SerializedName("productID") val productID: Int,
    val title: String,
    val description: String,
    @SerializedName("image") val imageURL: String,
    val price: Double
)
