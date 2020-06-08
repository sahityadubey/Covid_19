package com.techienest.who.viewmodels

import androidx.lifecycle.*
import com.techienest.who.models.CovidData
import com.techienest.who.network.GetCovidDataRepository
import com.techienest.who.utils.GetConnectionStatus
import com.techienest.who.utils.GetCountryDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    //var to pass data in other class
    private var mutableLiveData : LiveData<CovidData>? = null

    init{
        if(GetConnectionStatus().hasActiveInternetConnection()){
            callAPIToGetData()
        }
    }

    //calling API to download the data
    fun callAPIToGetData(){
        mutableLiveData = liveData(Dispatchers.IO) {
            val retrievedData = GetCovidDataRepository.instance?.getCovidData(GetCountryDetails().getCountryCode())
            retrievedData?.let { emit(it) }
        }
    }

    //this method helps to return the livedata object
    fun getCovidDataFromRepository(): LiveData<CovidData>? {
        return mutableLiveData
    }
}