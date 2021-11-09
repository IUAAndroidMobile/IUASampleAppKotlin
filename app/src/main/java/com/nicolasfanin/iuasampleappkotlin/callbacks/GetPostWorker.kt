package com.nicolasfanin.iuasampleappkotlin.callbacks

import android.content.Context
import android.os.Handler

class GetPostWorker(context: Context) {

    private var listener: ActionListenerCallback? = null

    fun setActionListener(callback: ActionListenerCallback) {
        listener = callback
        // Realizar alguna tarea antes de invocar al callback.
        // En este ejemplo solo espera 5 segundos.

        val handler = Handler()
        handler.postDelayed(Runnable {

            if (listener != null) {
                callback.onActionSuccess("exito")
            } else {
                callback.onActionFailure(Throwable("Error"))
            }

        }, 5000)


    }
}