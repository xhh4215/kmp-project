package com.example.demo.network
import android.content.Context
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.component.KoinComponent
import org.koin.core.component.get


 actual  fun createSpaceXSDK(): SpaceXApi {
    val client = HttpClient(Android) {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true })
        }
    }
     val context = object : KoinComponent {}.get<Context>()


     return SpaceXSDKImpl(client)
}