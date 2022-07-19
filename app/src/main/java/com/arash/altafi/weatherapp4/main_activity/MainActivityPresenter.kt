package com.arash.altafi.weatherapp4.main_activity

import com.arash.altafi.weatherapp4.theme.ThemeManager
import com.arash.altafi.weatherapp4.weather.WeatherManager
import com.arash.altafi.weatherapp4.R

class MainActivityPresenter(
    private val screen: MainActivityContract.Screen,
    private val themeManager: ThemeManager,
    private val weatherManager: WeatherManager
) : MainActivityContract.UserAction {

    override fun onCreate(savedInstanceStateNull: Boolean) {
        updateScreen()
        weatherManager.load()
    }

    override fun onResume() {
        weatherManager.load()
    }

    private fun updateScreen() {
        updateTheme()
    }

    private fun updateTheme() {
        val light = themeManager.isLight()
        screen.setStatusBarTheme(
            if (light) {
                R.color.main_activity_status_bar_light_theme_color
            } else {
                R.color.main_activity_status_bar_dark_theme_color
            },
            themeDark = !light
        )
        screen.setNavigationBarTheme(
            if (light) {
                R.color.main_activity_navigation_bar_light_theme_color
            } else {
                R.color.main_activity_navigation_bar_dark_theme_color
            },
            themeDark = !light
        )
    }
}
