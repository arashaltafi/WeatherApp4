package com.arash.altafi.weatherapp4.graph

import android.annotation.SuppressLint
import android.content.Context
import com.arash.altafi.weatherapp4.city.CityModule
import com.arash.altafi.weatherapp4.date.DateModule
import com.arash.altafi.weatherapp4.network.NetworkModule
import com.arash.altafi.weatherapp4.theme.ThemeModule
import com.arash.altafi.weatherapp4.weather.WeatherModule
import com.arash.altafi.weatherapp4.weather_unit.WeatherUnitModule

class WeatherGraph private constructor(
    private val context: Context
) {

    private val cityManager by lazy { CityModule().createCityManager() }
    private val dateManager by lazy { DateModule().createDateManager() }
    private val networkManager by lazy { NetworkModule().createNetworkManager() }
    private val themeManager by lazy { ThemeModule().createThemeManager() }
    private val weatherGraphInitializationManager by lazy { WeatherGraphInitializationModule().createWeatherGraphInitializationManager() }
    private val weatherManager by lazy { WeatherModule().createWeatherManager() }
    private val weatherUnitManager by lazy { WeatherUnitModule().createWeatherUnitManager() }

    companion object {

        @SuppressLint("StaticFieldLeak")
        private var graph: WeatherGraph? = null

        fun initialize(context: Context) {
            if (graph != null) {
                return
            }
            graph = WeatherGraph(context.applicationContext)
            graph!!.weatherGraphInitializationManager.initialize()
        }

        fun getCityManager() = graph!!.cityManager
        fun getDateManager() = graph!!.dateManager
        fun getContext() = graph!!.context
        fun getNetworkManager() = graph!!.networkManager
        fun getThemeManager() = graph!!.themeManager
        fun getWeatherManager() = graph!!.weatherManager
        fun getWeatherUnitManager() = graph!!.weatherUnitManager
    }
}
