package com.test.apod.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.test.apod.api.ApodService
import com.test.apod.db.ApodDatabase
import com.test.apod.models.DataModel
import com.test.apod.utils.NetworkUtils

class ApodRepository(
    private val apodService: ApodService,
    private val apodDatabase: ApodDatabase,
    private val applicationContext: Context
) {

    private val apodLiveData = MutableLiveData<DataModel>()

    val data: LiveData<DataModel?>
    get() = apodLiveData

    suspend fun getData(key: String){

        if(NetworkUtils.isInternetAvailable(applicationContext)){
            val data = apodService.getData(key)
            if(data.body() != null){
                apodDatabase.apodDao().addData(data.body()!!)
                apodLiveData.postValue(data.body())
            }
        }
        else{
            val data = apodDatabase.apodDao().getData()
            apodLiveData.postValue(data)
        }

    }
}







