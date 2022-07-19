package com.arash.altafi.weatherapp4.main_view_top_bar_view

import androidx.lifecycle.MutableLiveData
import com.arash.altafi.weatherapp4.date.DateManager
import com.arash.altafi.weatherapp4.weather.Weather
import com.arash.altafi.weatherapp4.weather.WeatherManager
import com.arash.altafi.weatherapp4.weather_unit.WeatherUnit
import com.arash.altafi.weatherapp4.weather_unit.WeatherUnitManager

class MainViewTopBarViewPresenter(
    private val screen: MainViewTopBarViewContract.Screen,
    private val cityManager: com.arash.altafi.weatherapp4.city.CityManager,
    private val dateManager: DateManager,
    private val weatherManager: WeatherManager,
    private val weatherUnitManager: WeatherUnitManager
) : MainViewTopBarViewContract.UserAction {

    private var city = MutableLiveData(createCity())
    private var date = MutableLiveData(createDate())
    private var temperature = MutableLiveData(createTemperature())
    private var weatherType = MutableLiveData(Weather.Type.SNOW)

    init {
        // Require remove call?
        cityManager.addListener(createCityListener())
        weatherManager.addListener(createWeatherListener())
    }

    override fun getCity(): MutableLiveData<String> {
        return city
    }

    override fun getDate(): MutableLiveData<String> {
        return date
    }

    override fun getTemperature(): MutableLiveData<String> {
        return temperature
    }

    override fun getWeatherType(): MutableLiveData<Weather.Type> {
        return weatherType
    }

    override fun onTemperatureClick() {
    }

    override fun onCityClicked() {
    }

    override fun onTemperatureUnitClicked(weatherUnit: WeatherUnit) {
        weatherUnitManager.setWeatherUnit(weatherUnit)
    }

    override fun onTemperatureUnitDisplay(metric: WeatherUnit): Boolean {
        return weatherUnitManager.getWeatherUnit() == metric
    }

    private fun updateCity() {
        city.value = createCity()
    }

    private fun updateDate() {
        date.value = createDate()
    }

    private fun updateTemperature() {
        temperature.value = createTemperature()
    }

    private fun updateWeatherType() {
        weatherType.value = createWeatherType()
    }

    private fun createCity(): String {
        return cityManager.getCity()
    }

    private fun createDate(): String {
        val weather = weatherManager.getWeathers().firstOrNull() ?: return ""
        return dateManager.convertTimestampToSpecificFormat1(weather.timestampSecond)
    }

    private fun createTemperature(): String {
        val weather = weatherManager.getWeathers().firstOrNull() ?: return ""
        val temperature = weather.temperature.toInt()
        return "$temperature°"
    }

    private fun createWeatherType(): Weather.Type {
        val weather = weatherManager.getWeathers().firstOrNull() ?: return Weather.Type.SNOW
        return weather.type
    }

    private fun createCityListener() = object : com.arash.altafi.weatherapp4.city.CityManager.Listener {
        override fun onChanged() {
            updateCity()
        }
    }

    private fun createWeatherListener() = object : WeatherManager.Listener {
        override fun onChanged() {
            updateDate()
            updateTemperature()
            updateWeatherType()
        }

        override fun onFailed() {
        }
    }
}
