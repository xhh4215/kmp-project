package com.example.demo.network

import RocketLaunch
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class SpaceXSDKImpl(private val client: HttpClient) : SpaceXApi {

    suspend fun getRemoteLaunches(): List<RocketLaunch> {
        return client.get("https://api.spacexdata.com/v4/launches").body()
    }

    @Throws(Exception::class)
    override suspend fun getAllLaunches(): List<RocketLaunch> {
        return getRemoteLaunches()
    }
}