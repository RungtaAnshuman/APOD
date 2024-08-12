package com.test.apod.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.test.apod.models.DataModel

@Database(entities = [DataModel::class], version = 1)
abstract class ApodDatabase : RoomDatabase() {

    abstract fun apodDao() : ApodDao

    companion object{
        @Volatile
        private var INSTANCE: ApodDatabase? = null

        fun getDatabase(context: Context): ApodDatabase {
            if (INSTANCE == null) {
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context,
                        ApodDatabase::class.java,
                        "apodDB")
                        .build()
                }
            }
            return INSTANCE!!
        }
    }
}