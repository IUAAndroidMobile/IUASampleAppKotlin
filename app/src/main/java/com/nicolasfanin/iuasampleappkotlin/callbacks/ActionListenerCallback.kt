package com.nicolasfanin.iuasampleappkotlin.callbacks

interface ActionListenerCallback {

    fun onActionSuccess(successMessage: String)

    fun onActionFailure(throwableError: Throwable)
}