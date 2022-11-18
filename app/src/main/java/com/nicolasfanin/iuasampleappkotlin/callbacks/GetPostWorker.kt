package com.nicolasfanin.iuasampleappkotlin.callbacks

import android.content.Context
import com.nicolasfanin.iuasampleappkotlin.networking.museum.NetworkingImplementation
import com.nicolasfanin.iuasampleappkotlin.networking.museum.dataClasses.MuseumItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetPostWorker(context: Context) {

    private var listener: ActionListenerCallback? = null

    private lateinit var response: Call<MuseumItem>

    private lateinit var qrid: String

    fun setQRId(qrId: String) {
        this.qrid = qrId
    }

    fun doWork(callback: ActionListenerCallback) {
        listener = callback
        // Realizar alguna tarea antes de invocar al callback.

            val museumService = NetworkingImplementation().service
            response = museumService.getMuseumItem()

            response.enqueue(object : Callback<MuseumItem> {
                override fun onResponse(call: Call<MuseumItem>, response: Response<MuseumItem>) {
                    response.body()?.let {
                        callback.onActionSuccess(it)
                    }
                }

                override fun onFailure(call: Call<MuseumItem>, t: Throwable) {
                    //Falla
                    callback.onActionFailure(t)
                }
            })
    }
}