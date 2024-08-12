package com.test.apod.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "data")
data class DataModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val copyright: String?,
    val date: String?,
    val explanation: String?,
    val hdurl: String?,
    val media_type: String?,
    val service_version: String?,
    val title: String?,
    val url: String?
)