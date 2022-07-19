package com.arash.altafi.weatherapp4.city_edit_view

import java.util.Locale

class CityEditViewPresenter(
    private val screen: CityEditViewContract.Screen,
    private val cityManager: com.arash.altafi.weatherapp4.city.CityManager
) : CityEditViewContract.UserAction {

    override fun onCityValidated(text: String) {
        cityManager.setCity(text.capitalize(Locale.getDefault()))
    }

    override fun onInfoClicked() {
    }
}
