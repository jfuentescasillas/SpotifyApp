package com.example.tarea004_spotifyapp.data.authentication

import com.example.tarea004_spotifyapp.data.network.AuthenticationService
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import java.lang.Exception
import okhttp3.Authenticator


class RenewAuthenticationToken(): Authenticator {
    lateinit var service: AuthenticationService


    private fun renewAccessToken(): String {
        if (::service.isInitialized){
            val myService = service.renewAuthenticationToken("client_credentials")

            try {
                val token = myService.execute().body()

                if (token != null){
                    return token.access_token
                }
            } catch (e:Exception){
                return ""
            }
        }

        return ""
    }


    override fun authenticate(route: Route?, response: Response): Request {
        val token = renewAccessToken()

        return response.request.newBuilder().header("Authorization", "Bearer $token").build()
    }
}