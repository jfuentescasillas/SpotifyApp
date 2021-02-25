package com.example.tarea004_spotifyapp.data

import android.content.ClipData
import com.example.tarea004_spotifyapp.data.model.ResponseAllSongsDataModel
import com.example.tarea004_spotifyapp.data.model.Song
import com.example.tarea004_spotifyapp.data.network.SongNetwork
import retrofit2.http.Body
import retrofit2.http.POST


class SongRepository {
    suspend fun getSongList(): List<Song> {
        return SongNetwork().getPlayList().items
    }
}