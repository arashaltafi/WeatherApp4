package com.arash.altafi.weatherapp4.date

class DateModule {

    fun createDateManager(): DateManager {
        return DateManagerImpl()
    }
}
