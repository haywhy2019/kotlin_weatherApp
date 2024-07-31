package com.flint.weatherapp.screens.main

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.flint.weatherapp.data.DataOrException
import com.flint.weatherapp.model.WeatherItem
import com.flint.weatherapp.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: WeatherRepository) : ViewModel() {

    suspend fun getWeatherData(lat: String, lon: String): DataOrException<WeatherItem, Boolean, Exception> {
        return repository.getWeather(lat, lon)
    }
}