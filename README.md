# WeatherApp_Retrofit

## Overview
WeatherApp_Retrofit is an Android application that provides weather forecasts for cities worldwide. Users can enter the name of a city, and upon clicking the 'Get Weather' button, the app displays the current weather conditions, including an image of the weather, the city and region name, weather type, and temperature in Celsius.

## Screenshots


<img src="https://github.com/Vishalbhardwj/WeatherApp_Retrofit/assets/139758910/bf9891ce-1b8b-4920-8826-7e042e54d7d9" width="220" height="350">



## Features
- **City Search:** Users can search for weather forecasts by city name.
- **Weather Display:** Showcases weather images using Glide, along with details like city, region, weather type, and temperature.
- **API Integration:** Utilizes WeatherAPI.com for fetching real-time weather data.

## Tech Stack
- **Language:** Kotlin
- **Architecture:** MVVM (Model-View-ViewModel)
- **Networking:** Retrofit Library for REST API calls
- **Image Loading:** Glide for Android

## Getting Started
To run the project locally, follow these steps:
1. Clone the repository: git clone https://github.com/Vishalbhardwj/WeatherApp_Retrofit.git
3. Open the project in Android Studio.
4. Build the project and run it on an emulator or device.

## Dependencies
```kotlin
dependencies {
    // Retrofit for network calls
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // Kotlin Coroutines for asynchronous tasks
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0")

    // Architecture Components for implementing MVVM
    implementation("androidx.lifecycle:lifecycle-viewmodel:2.4.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0")
    implementation("androidx.lifecycle:lifecycle-livedata:2.4.0")

    // Glide for image loading
    implementation("com.github.bumptech.glide:glide:4.16.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.16.0")
}


