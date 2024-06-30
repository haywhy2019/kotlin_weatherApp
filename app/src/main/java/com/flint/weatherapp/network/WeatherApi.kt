package com.flint.weatherapp.network

import com.flint.weatherapp.model.WeatherItem
import com.flint.weatherapp.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton


@Singleton
interface WeatherApi {
    @GET(value= "data/3.0/onecall")
    suspend fun getWeather(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("appid") appId: String = Constants.API_KEY
    ) : WeatherItem
}

//?lat={lat}&lon={lon}&exclude={part}&appid={API key}