package com.test.apod.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.apod.models.DataModel
import com.test.apod.repository.ApodRepository
import com.test.apod.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: ApodRepository) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO){
            repository.getData(Constants.API_KEY)
        }
    }

    val data : LiveData<DataModel?>
    get() = repository.data
}