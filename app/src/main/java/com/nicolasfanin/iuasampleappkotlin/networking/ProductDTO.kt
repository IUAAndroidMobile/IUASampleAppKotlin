package com.nicolasfanin.iuasampleappkotlin.networking

data class ProductDTO(
    val productID: Int,
    val title: String,
    val description: String,
    val imageURL: String,
    val price: Double
)
