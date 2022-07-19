package com.arash.altafi.weatherapp4.network

class NetworkModule {

    fun createNetworkManager(): NetworkManager {
        return NetworkManagerImpl()
    }
}
