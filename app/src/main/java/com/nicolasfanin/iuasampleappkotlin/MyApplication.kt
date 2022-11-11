package com.nicolasfanin.iuasampleappkotlin

import android.app.Application
import android.content.Context
import com.nicolasfanin.iuasampleappkotlin.database.MyAppRoomDatabase
import com.nicolasfanin.iuasampleappkotlin.preferences.MySharedPreferences

class MyApplication: Application() {

    companion object {
        lateinit var preferences: MySharedPreferences
        lateinit var myApplicationContex : Context
        lateinit var myAppDatabase: MyAppRoomDatabase
    }

    override fun onCreate() {
        super.onCreate()
        preferences = MySharedPreferences(applicationContext)
        myApplicationContex = applicationContext
        myAppDatabase = MyAppRoomDatabase.roomDatabase
    }
}