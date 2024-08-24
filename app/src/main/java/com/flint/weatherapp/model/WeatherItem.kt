package com.flint.weatherapp.model

data class WeatherItem(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<WeatherObject>,
    val message: Int
)