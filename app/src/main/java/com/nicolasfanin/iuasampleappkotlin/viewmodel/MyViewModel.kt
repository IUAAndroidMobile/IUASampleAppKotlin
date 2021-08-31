package com.nicolasfanin.iuasampleappkotlin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nicolasfanin.iuasampleappkotlin.Color

class MyViewModel : ViewModel() {
    private var colorsList = MutableLiveData<List<Color>>()

    fun getColors(): LiveData<List<Color>> = colorsList

    private fun loadColors() {
        val colors = mutableListOf<Color>()
        colors.add(Color("Blue", "#2196F3"))
        //...
        colorsList.value = colors
    }
}