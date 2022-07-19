package com.arash.altafi.weatherapp4.main_activity

import androidx.annotation.ColorRes

interface MainActivityContract {

    interface UserAction {

        fun onCreate(savedInstanceStateNull: Boolean)

        fun onResume()
    }

    interface Screen {

        fun setStatusBarTheme(@ColorRes colorRes: Int, themeDark: Boolean)

        fun setNavigationBarTheme(@ColorRes colorRes: Int, themeDark: Boolean)
    }
}
