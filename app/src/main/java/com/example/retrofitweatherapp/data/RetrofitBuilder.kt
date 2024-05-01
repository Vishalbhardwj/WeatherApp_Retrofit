package com.example.retrofitweatherapp.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {

    companion object{

        var retrofitWeatherService:RetrofitWeatherService? =null

        fun getInstance():RetrofitWeatherService{
            if(retrofitWeatherService==null){
                retrofitWeatherService=Retrofit.Builder()
                    .baseUrl("https://api.weatherapi.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(RetrofitWeatherService::class.java)
            }
            return retrofitWeatherService!!
        }
    }
}