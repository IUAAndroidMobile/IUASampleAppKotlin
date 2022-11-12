package com.nicolasfanin.iuasampleappkotlin.networking

import retrofit2.Call
import retrofit2.http.GET

interface ProductsServices {


    @GET("v1/225e8d5e-9eca-415a-88ff-42cdd4d78d5e")
    fun getProductList() : Call<List<ProductDTO>>

    @GET("v1/000000000000000000000000000000000000")
    fun getProductById(): ProductDTO

    @GET("v1/000000000000000000000000000000000000")
    fun getRecomendedProducts(): List<ProductDTO>

}