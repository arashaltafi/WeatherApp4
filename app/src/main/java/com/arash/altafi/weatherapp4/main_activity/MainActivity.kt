package com.arash.altafi.weatherapp4.main_activity

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowInsetsController
import androidx.activity.compose.setContent
import androidx.annotation.ColorRes
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.arash.altafi.weatherapp4.graph.WeatherGraph
import com.arash.altafi.weatherapp4.main_view.MainView
import com.arash.altafi.weatherapp4.theme.MainTheme

class MainActivity : AppCompatActivity() {

    private val userAction by lazy { createUserAction() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainTheme {
                MainView()
            }
        }
        userAction.onCreate(savedInstanceState == null)
    }

    override fun onResume() {
        super.onResume()
        userAction.onResume()
    }

    private fun createScreen() = object : MainActivityContract.Screen {

        @Suppress("DEPRECATION")
        override fun setStatusBarTheme(@ColorRes colorRes: Int, themeDark: Boolean) {
            val color = ContextCompat.getColor(this@MainActivity, colorRes)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                window.insetsController!!.setSystemBarsAppearance(
                    if (themeDark) 0 else WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS,
                    WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
                )
                window.statusBarColor = color
            } else {
                window.statusBarColor = color
                val flags = window.decorView.systemUiVisibility
                window.decorView.systemUiVisibility = if (themeDark) {
                    flags and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
                } else {
                    flags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                }
            }
        }

        override fun setNavigationBarTheme(@ColorRes colorRes: Int, themeDark: Boolean) {
            val color = ContextCompat.getColor(this@MainActivity, colorRes)
            window.navigationBarColor = if (color == Color.WHITE) {
                // Not supported nicely as buttons will stay white, so use black color instead.
                Color.BLACK
            } else {
                color
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                window.insetsController!!.setSystemBarsAppearance(
                    if (themeDark) 0 else WindowInsetsController.APPEARANCE_LIGHT_NAVIGATION_BARS,
                    WindowInsetsController.APPEARANCE_LIGHT_NAVIGATION_BARS
                )
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                setNavigationBarButtonColor(window, !themeDark)
            }
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        private fun setNavigationBarButtonColor(window: Window, darkButton: Boolean) {
            val flags = window.decorView.systemUiVisibility
            window.decorView.systemUiVisibility = if (darkButton) {
                flags or View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
            } else {
                flags and View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR.inv()
            }
        }
    }

    private fun createUserAction(): MainActivityContract.UserAction {
        return MainActivityPresenter(
            createScreen(),
            WeatherGraph.getThemeManager(),
            WeatherGraph.getWeatherManager()
        )
    }
}
