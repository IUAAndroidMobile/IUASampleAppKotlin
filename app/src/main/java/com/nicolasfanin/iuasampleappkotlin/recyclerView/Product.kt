package com.nicolasfanin.iuasampleappkotlin.recyclerView

data class Product(
    val title: String,
    val description: String,
    val imageURL: String,
    val price: Double = 0.0
)
