package com.nicolasfanin.iuasampleappkotlin.networking.museum

import com.nicolasfanin.iuasampleappkotlin.networking.museum.dataClasses.MuseumItem
import retrofit2.Call
import retrofit2.http.GET

interface MuseumService {

    @GET("v1/407de6c2-afa3-496d-b712-3b0f4ade0e14")
    fun getMuseumItem() : Call<MuseumItem>

    @GET("https://mocki.io/v1/407de6c2-afa3-496d-b712-3b0f4ade0e14")
    fun getMuseumItemList() : Call<String>
}