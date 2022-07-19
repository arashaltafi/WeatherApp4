package com.arash.altafi.weatherapp4.theme

import android.content.Context
import com.arash.altafi.weatherapp4.R

class ThemeManagerImpl(
    private val context: Context
) : ThemeManager {

    override fun isLight(): Boolean {
        return context.resources.getBoolean(R.bool.theme_bool_light_mode)
    }
}
