package com.nicolasfanin.iuasampleappkotlin.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProductRetrofit {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://mocki.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val productService: ProductsServices = retrofit.create(ProductsServices::class.java)

}