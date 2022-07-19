package com.arash.altafi.weatherapp4.main_view_top_bar_view

import androidx.lifecycle.MutableLiveData
import com.arash.altafi.weatherapp4.weather.Weather
import com.arash.altafi.weatherapp4.weather_unit.WeatherUnit

interface MainViewTopBarViewContract {

    interface UserAction {

        fun getCity(): MutableLiveData<String>

        fun getDate(): MutableLiveData<String>

        fun getTemperature(): MutableLiveData<String>

        fun getWeatherType(): MutableLiveData<Weather.Type>

        fun onTemperatureClick()

        fun onCityClicked()

        fun onTemperatureUnitClicked(weatherUnit: WeatherUnit)

        /**
         * @return True if current
         */
        fun onTemperatureUnitDisplay(metric: WeatherUnit): Boolean
    }

    interface Screen
}
