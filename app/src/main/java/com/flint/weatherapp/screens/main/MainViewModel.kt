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
    val data: MutableState<DataOrException<WeatherItem, Boolean, Exception>> = mutableStateOf(
        DataOrException(
            null, true,
            Exception("")
        )
    )

    init {
        loadWeather()
    }

    private fun loadWeather() {
        getWeather("44.34", "10.99")
    }

    private fun getWeather( lat: String, lon: String) {
        viewModelScope.launch {
        if(lon.isEmpty()) return@launch
            data.value.loading = true
            data.value = repository.getWeather(lat, lon)
            if(data.value.data.toString().isEmpty()) {
                data.value.loading = false
            }
            Log.d("GET", "getweather: ${data.value.toString()}")
        }
    }
}