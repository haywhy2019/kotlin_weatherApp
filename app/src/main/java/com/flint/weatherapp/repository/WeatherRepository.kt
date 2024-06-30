package com.flint.weatherapp.repository

import com.flint.weatherapp.data.DataOrException
import com.flint.weatherapp.model.WeatherItem
import com.flint.weatherapp.network.WeatherApi
import javax.inject.Inject

class WeatherRepository @Inject constructor(private  val api: WeatherApi) {
suspend fun  getWeather(lat: String, lon: String) : DataOrException<WeatherItem,
        Boolean, Exception>
{
val response = try {
api.getWeather(lat,lon)
} catch (e: Exception) {
    return DataOrException(e = e)
}
    return DataOrException(data = response)

}}