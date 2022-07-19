package com.arash.altafi.weatherapp4.date

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DateManagerImpl : DateManager {

    override fun convertTimestampToSpecificFormat1(timestampSecond: Long): String {
        val locale = Locale.getDefault()
        val simpleDateFormat = SimpleDateFormat("E dd", locale)
        return simpleDateFormat.format(Date(timestampSecond * 1_000)).capitalize(locale)
    }
}
