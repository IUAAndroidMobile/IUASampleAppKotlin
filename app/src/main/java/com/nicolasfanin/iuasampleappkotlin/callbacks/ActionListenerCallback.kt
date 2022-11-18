package com.nicolasfanin.iuasampleappkotlin.callbacks

import com.nicolasfanin.iuasampleappkotlin.networking.museum.dataClasses.MuseumItem

interface ActionListenerCallback {

    fun onActionSuccess(successMessage: MuseumItem)

    fun onActionFailure(throwableError: Throwable)
}