package com.flint.weatherapp.repository

import android.util.Log
import com.flint.weatherapp.data.DataOrException
import com.flint.weatherapp.model.WeatherItem
import com.flint.weatherapp.network.WeatherApi
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val api: WeatherApi) {
    suspend fun getWeather(lat: String, lon: String): DataOrException<WeatherItem,
            Boolean, Exception> {
        val response = try {
            api.getWeather(lat, lon)
        } catch (e: Exception) {
            Log.d("GETerr", "getweather: ${e.message}")
            return DataOrException(e = e)
        }
        Log.d("GET", "getweather: ${response}")
        return DataOrException(data = response)

    }
}