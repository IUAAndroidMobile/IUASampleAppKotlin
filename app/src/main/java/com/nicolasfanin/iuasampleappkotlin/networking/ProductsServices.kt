package com.nicolasfanin.iuasampleappkotlin.networking

import retrofit2.Call
import retrofit2.http.GET

interface ProductsServices {

    @GET("v1/225e8d5e-9eca-415a-88ff-42cdd4d78d5e")
    //@GET("v1/a128ade5-b3db-4a69-b72a-397206052cf2")
    fun getProductList() : Call<ProductListDTO>

    @GET("v1/000000000000000000000000000000000000")
    fun getProductById(): ProductDTO

    @GET("v1/000000000000000000000000000000000000")
    fun getRecomendedProducts(): List<ProductDTO>

}