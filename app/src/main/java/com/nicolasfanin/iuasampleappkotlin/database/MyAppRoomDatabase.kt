package com.nicolasfanin.iuasampleappkotlin.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nicolasfanin.iuasampleappkotlin.MyApplication
import com.nicolasfanin.iuasampleappkotlin.database.model.ProductDao
import com.nicolasfanin.iuasampleappkotlin.database.model.ProductEntity

@Database(entities = [ProductEntity::class], version = 1)
abstract class MyAppRoomDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDao

    companion object {
        val roomDatabase: MyAppRoomDatabase = Room.databaseBuilder(
            MyApplication.myApplicationContex,
            MyAppRoomDatabase::class.java,
            "com.nicolasfanin.iuasampleappkotlin.roomdatabase"
        ).build()
    }

}