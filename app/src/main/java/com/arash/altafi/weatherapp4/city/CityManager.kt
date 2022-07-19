package com.arash.altafi.weatherapp4.city

interface CityManager {

    fun getCity(): String

    fun setCity(city: String)

    fun addListener(listener: Listener)

    fun removeListener(listener: Listener)

    interface Listener {

        fun onChanged()
    }
}
