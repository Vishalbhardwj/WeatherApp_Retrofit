package com.example.retrofitweatherapp

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.retrofitweatherapp.data.RetrofitBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var repo: Repo
    private lateinit var weatherViewModel: WeatherViewModel
    private lateinit var weatherViewModelFactory: WeatherViewModelFactory
    private lateinit var progressBar: ProgressBar

    private lateinit var edtcityName:EditText
    private lateinit var btnGetWeather:Button
    private lateinit var cityState:TextView
    private lateinit var weatherIcon:ImageView
    private lateinit var weatherTemp:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        init()

        btnGetWeather.setOnClickListener(){
            weatherViewModel.getAllWeatherDetails(edtcityName.text.toString())


        }

        weatherViewModel.weatherLiveData.observe(this){
            val cityname =it.location.name
            val stateName = it.location.region
            cityState.text = "$cityname, $stateName"

            val IconLink = "https:${it.current.condition.icon}"
            Glide.with(this)
                .load(IconLink)
                .into(weatherIcon)




            val weathertype = it.current.condition.text
            val weatherTempInC = it.current.temp_c.toString()
            weatherTemp.text = "$weathertype, $weatherTempInC"
            Log.i("WeatherDetails",it.toString())
        }



        weatherViewModel.isLoading.observe(this){
            if(it){
                progressBar.visibility = View.VISIBLE
            }else{
                progressBar.visibility = View.GONE
            }
        }


    }

    private fun init(){
        repo = Repo(RetrofitBuilder.getInstance())
        weatherViewModelFactory = WeatherViewModelFactory(repo)
        weatherViewModel = ViewModelProvider(this,weatherViewModelFactory).get(WeatherViewModel::class.java)

        progressBar = findViewById(R.id.prog_bar)

        edtcityName = findViewById(R.id.edt_city_name)
        btnGetWeather = findViewById(R.id.btn_get_weather)
        cityState = findViewById(R.id.text_city_state)
        weatherIcon = findViewById(R.id.weather_icon)
        weatherTemp = findViewById(R.id.text_weather_temp)
    }
}