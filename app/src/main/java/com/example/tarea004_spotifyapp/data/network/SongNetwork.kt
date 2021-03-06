package com.example.tarea004_spotifyapp.data.network

import com.example.tarea004_spotifyapp.BuildConfig
import com.example.tarea004_spotifyapp.data.authentication.RenewAuthenticationToken
import com.example.tarea004_spotifyapp.data.model.ResponseAllSongsDataModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class SongNetwork() {
    lateinit var service: SongService


    private fun loadSongListRetrofit(authenticationToken: String) {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.spotify.com")
            .addConverterFactory(GsonConverterFactory.create())
            .client(createHttpClient(authenticationToken))
            .build()

        service = retrofit.create(SongService::class.java)
    }


    private fun createHttpClient(authenticationToken: String): OkHttpClient {
        // Create OkHttpClient
        val builder = OkHttpClient.Builder()
            .connectTimeout(60L, TimeUnit.SECONDS)
            .readTimeout(60L, TimeUnit.SECONDS)
            .writeTimeout(60L, TimeUnit.SECONDS)

        // Logger interceptor
        val loggerInterceptor = HttpLoggingInterceptor()
        loggerInterceptor.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        builder.addInterceptor(loggerInterceptor)

        // App token
        builder.addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("Authorization", "Bearer $authenticationToken")
                .build()
            chain.proceed(request)
        }

        builder.authenticator(RenewAuthenticationToken())
            .connectTimeout(60L, TimeUnit.SECONDS)
            .followRedirects(false)
            .followSslRedirects(false)

        return builder.build()
    }


    suspend fun getPlayList(): ResponseAllSongsDataModel {
        // Temporarily solution as seen on class the 24-02-2021
        val authToken = AuthenticationNetwork().getAuthenticationToken().access_token
        loadSongListRetrofit(authToken)

        return service.getPlayList()
    }
}