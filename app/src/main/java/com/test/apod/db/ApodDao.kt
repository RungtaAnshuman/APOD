package com.test.apod.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.test.apod.models.DataModel

@Dao
interface ApodDao {

    @Insert
    suspend fun addData(data: DataModel)

    @Query("SELECT * FROM data")
    suspend fun getData() : DataModel
}