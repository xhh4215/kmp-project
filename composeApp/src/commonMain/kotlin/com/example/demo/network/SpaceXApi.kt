package com.example.demo.network

import RocketLaunch

interface SpaceXApi {
    @Throws(Exception::class)

    suspend fun getAllLaunches(): List<RocketLaunch>
}