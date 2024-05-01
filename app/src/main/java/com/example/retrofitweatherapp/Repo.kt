package com.example.retrofitweatherapp

import com.example.retrofitweatherapp.data.RetrofitWeatherService
import com.example.retrofitweatherapp.data.WeatherDataModel
import retrofit2.Response

class Repo(
    private val retrofitWeatherService: RetrofitWeatherService
) {
    suspend fun getAllWeatherDetails(city:String)=retrofitWeatherService.getAllWeatherDetail(city)

}