package com.flint.weatherapp.screens.main

import com.flint.weatherapp.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private  val repository: WeatherRepository){
}