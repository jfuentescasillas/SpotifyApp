package com.example.tarea004_spotifyapp.data

import com.example.tarea004_spotifyapp.data.model.ResponseAuthenticationDataModel
import com.example.tarea004_spotifyapp.data.network.AuthenticationNetwork


class AuthenticationRepository {
    suspend fun getAuthenticationToken(): ResponseAuthenticationDataModel {
        return AuthenticationNetwork().getAuthenticationToken()
    }
}