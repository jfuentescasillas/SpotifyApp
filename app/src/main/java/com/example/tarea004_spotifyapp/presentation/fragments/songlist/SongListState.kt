package com.example.tarea004_spotifyapp.presentation.fragments.songlist

import com.example.tarea004_spotifyapp.data.model.Song
import java.io.Serializable


class SongListState (
    val playList: List<Song> = listOf()
): Serializable