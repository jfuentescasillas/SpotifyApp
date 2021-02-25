package com.example.tarea004_spotifyapp.data.network

import com.example.tarea004_spotifyapp.data.model.ResponseAllSongsDataModel
import retrofit2.http.GET


interface SongService {
    @GET("/v1/playlists/37i9dQZF1DXcd2Vmhfon1w/tracks?offset=0&limit=100") //{playlist_id}")
    suspend fun getPlayList(): ResponseAllSongsDataModel
}