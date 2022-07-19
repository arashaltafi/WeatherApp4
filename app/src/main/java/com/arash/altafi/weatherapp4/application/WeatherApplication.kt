package com.arash.altafi.weatherapp4.application

import android.app.Application
import com.arash.altafi.weatherapp4.graph.WeatherGraph

class WeatherApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        WeatherGraph.initialize(this)
    }
}
