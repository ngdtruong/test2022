package com.example.test2022.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test2022.model.MediaList
import com.example.test2022.repository.MediaRepository
import com.example.test2022.repository.MediaRepositoryImpl
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    private var mediaRepository: MediaRepository? = null
    private var listMediaLiveData = MutableLiveData<List<MediaList>>()
    private var errorLiveData = MutableLiveData<String>()

    init {
        mediaRepository = MediaRepositoryImpl.instance
    }

    fun fetchData(){
        viewModelScope.launch {
            try {
                val response = mediaRepository?.fetchData()
                if (response!!.isEmpty()){
                    errorLiveData.value = "Error!!!"
                    listMediaLiveData.postValue(null)
                }else listMediaLiveData.postValue(response)

            }catch (e: Exception){
                errorLiveData.value = "Error!!!"
                listMediaLiveData.postValue(null)
            }
        }
    }

    fun getData(): LiveData<List<MediaList>>{
        return listMediaLiveData
    }

    fun errorLiveData(): LiveData<String>{
        return errorLiveData
    }
}