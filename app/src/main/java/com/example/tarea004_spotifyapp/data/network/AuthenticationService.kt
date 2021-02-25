package com.example.tarea004_spotifyapp.data.network

import com.example.tarea004_spotifyapp.data.model.ResponseAuthenticationDataModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


interface AuthenticationService {
    @FormUrlEncoded
    @POST("/api/token")
    suspend fun getAuthenticationToken(@Field("grant_type") granType: String): ResponseAuthenticationDataModel


    @FormUrlEncoded
    @POST("/api/token")
    fun renewAuthenticationToken( @Field("grant_type") granType: String): Call<ResponseAuthenticationDataModel>
}