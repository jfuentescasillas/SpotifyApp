package com.example.tarea004_spotifyapp.data.network

import com.example.tarea004_spotifyapp.BuildConfig
import com.example.tarea004_spotifyapp.data.model.ResponseAuthenticationDataModel
import okhttp3.Credentials
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class AuthenticationNetwork() {
    lateinit var serviceAuthentication: AuthenticationService

    /**
     * Load Retrofit
     */
    private fun loadRetrofit() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://accounts.spotify.com")
            .addConverterFactory(GsonConverterFactory.create())
            .client(createHttpClient())
            .build()

        serviceAuthentication = retrofit.create(AuthenticationService::class.java)
    }

    /**
     * Create HTTP Client
     */
    private fun createHttpClient(): OkHttpClient {
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
                .addHeader("Authorization", Credentials.basic(BuildConfig.PUBLIC_KEY, BuildConfig.PRIVATE_KEY))
                .build()
            chain.proceed(request)
        }

        return builder.build()
    }

    /**
     * Get the Authentication Token
     */
    suspend fun getAuthenticationToken(): ResponseAuthenticationDataModel {
        loadRetrofit()

        return serviceAuthentication.getAuthenticationToken("client_credentials")
    }
}