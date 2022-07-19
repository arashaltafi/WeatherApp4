package com.arash.altafi.weatherapp4.network

import androidx.annotation.WorkerThread

interface NetworkManager {

    @WorkerThread
    fun get(url: String): String?
}
