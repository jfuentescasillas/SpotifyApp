package com.example.tarea004_spotifyapp.data.model

data class ResponseAuthenticationDataModel(
    val access_token: String,
    val expires_in: Int,
    val scope: String,
    val token_type: String
)
