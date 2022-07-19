package com.arash.altafi.weatherapp4.city_edit_view

interface CityEditViewContract {

    interface UserAction {

        fun onCityValidated(text: String)

        fun onInfoClicked()
    }

    interface Screen
}
