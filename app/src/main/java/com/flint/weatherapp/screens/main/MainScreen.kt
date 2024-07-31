package com.flint.weatherapp.screens.main

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold


import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.flint.weatherapp.data.DataOrException
import com.flint.weatherapp.model.WeatherItem
import com.flint.weatherapp.widgets.WeatherAppBar


@SuppressLint("ProduceStateDoesNotAssignValue")
@Composable
fun MainScreen(navController: NavController, mainViewModel: MainViewModel = hiltViewModel()){
    val weatherData = produceState< DataOrException<WeatherItem, Boolean, Exception>>(
        initialValue = DataOrException(loading = true)){value = mainViewModel.getWeatherData("44.34", "10.99")}.value

    if(weatherData.loading == true) {
        CircularProgressIndicator()
    } else if (weatherData.data != null) {

        MainScaffold(weather = weatherData.data!!, navController)
    }
}


@Composable
fun MainScaffold(weather: WeatherItem, navController: NavController) {
Scaffold(
    topBar = {
    WeatherAppBar(
        title = "tolaaa",
        navController = navController,
        elevation = 5.dp,
    )
},
    content = {it -> Column(
        modifier = Modifier.padding(it)
    ) {
        MainContent(data = weather)
    }}
    )
}

@Composable
fun MainContent(data: WeatherItem) {
Text(text = data.sys.country)
}