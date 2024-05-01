package com.example.retrofitweatherapp.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface RetrofitWeatherService {

    @GET("/v1/current.json?key=47c5f1147dde464c96d195031242004")
    suspend fun getAllWeatherDetail(
        @Query("q") city:String
    ) :Response<WeatherDataModel>

}