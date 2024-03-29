package com.nicolasfanin.iuasampleappkotlin.preferences

import android.content.Context
import android.content.SharedPreferences

/**
 * Se puede ver mas info en el siguiente link: https://cursokotlin.com/capitulo-16-persistencia-datos-shared-preferences/
 *
 */
class MySharedPreferences(context: Context) {

    private val PREFS_NAME = "com.nicolasfanin.iuasampleappkotlin.sharedPreferences"

    val preferences : SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    private val KEY_USER_NAME = "USER_NAME"
    private val KEY_USER_AGE = "USER_AGE"

    fun setUserName(userName: String) {
        preferences.edit().putString(KEY_USER_NAME, userName).apply()
    }

    fun getUserName(): String {
        return preferences.getString(KEY_USER_NAME, "") ?: ""
    }

    fun setUserAge(userAge: Int) {
        preferences.edit().putInt(KEY_USER_AGE, userAge).apply()
    }

    fun getUserAge(): Int {
        return preferences.getInt(KEY_USER_AGE, 0)
    }

}