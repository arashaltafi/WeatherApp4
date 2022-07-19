package com.arash.altafi.weatherapp4.main_view

import androidx.lifecycle.MutableLiveData
import com.arash.altafi.weatherapp4.weather.Weather

interface MainViewContract {

    interface UserAction {

        fun getWeathers(): MutableLiveData<List<Weather>>

        fun getError(): MutableLiveData<Boolean>
    }

    interface Screen
}
