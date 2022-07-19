package com.arash.altafi.weatherapp4.forecast_cell_view

import com.arash.altafi.weatherapp4.date.DateManager
import com.arash.altafi.weatherapp4.weather.Weather

class ForecastCellViewPresenter(
    private val screen: ForecastCellViewContract.Screen,
    private val weather: Weather?,
    private val dateManager: DateManager
) : ForecastCellViewContract.UserAction {

    override fun onDisplayTextTemperature(): String {
        return createTemperatureToDisplay()
    }

    private fun createTemperatureToDisplay(): String {
        val weather = weather ?: return ""
        return dateManager.convertTimestampToSpecificFormat1(weather.timestampSecond)
    }
}
