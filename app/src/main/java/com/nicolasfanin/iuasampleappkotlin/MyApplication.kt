package com.nicolasfanin.iuasampleappkotlin

import android.app.Application
import com.nicolasfanin.iuasampleappkotlin.preferences.MySharedPreferences

class MyApplication: Application() {

    companion object {
        lateinit var preferences: MySharedPreferences
    }

    override fun onCreate() {
        super.onCreate()
        preferences = MySharedPreferences(applicationContext)
    }
}