package com.test.apod

import android.app.Application
import com.test.apod.api.ApodService
import com.test.apod.api.RetrofitHelper
import com.test.apod.db.ApodDatabase
import com.test.apod.repository.ApodRepository

class ApodApplication : Application() {

    lateinit var apodRepository: ApodRepository

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val apodService = RetrofitHelper.getInstance().create(ApodService::class.java)
        val database = ApodDatabase.getDatabase(applicationContext)
        apodRepository = ApodRepository(apodService, database, applicationContext)
    }

}