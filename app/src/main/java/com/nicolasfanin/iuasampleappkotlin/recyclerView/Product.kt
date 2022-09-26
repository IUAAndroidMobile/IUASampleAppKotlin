package com.nicolasfanin.iuasampleappkotlin.recyclerView


data class Product(
    val title: String,
    val description: String,
    val image: String,
    val price: Double? = 100.00
)
