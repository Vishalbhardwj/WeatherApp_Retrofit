package com.example.retrofitweatherapp

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitweatherapp.data.WeatherDataModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val repo: Repo
): ViewModel(){

    val weatherLiveData = MutableLiveData<WeatherDataModel>()
    var isLoading = MutableLiveData<Boolean>(false)


     fun getAllWeatherDetails(city:String){
       viewModelScope.launch(Dispatchers.IO){
           isLoading.postValue(true)
           val response =repo.getAllWeatherDetails(city)

           if(response.isSuccessful){
               val weatherData =response.body()
               if(weatherData!=null){
                   weatherLiveData.postValue(weatherData)
                   isLoading.postValue(false)
                   Log.i("weather","Details are comming from api.")
               }else{
                    Log.i("weatherDetails", "Error:Unable to fetch Data.")
               }
           }else{
               Log.i("weatherDetails","Error:${response.code()}")
           }
       }
    }

}