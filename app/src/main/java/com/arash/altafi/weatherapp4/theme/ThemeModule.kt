package com.arash.altafi.weatherapp4.theme

import com.arash.altafi.weatherapp4.graph.WeatherGraph

class ThemeModule {

    fun createThemeManager(): ThemeManager {
        return ThemeManagerImpl(WeatherGraph.getContext())
    }
}
