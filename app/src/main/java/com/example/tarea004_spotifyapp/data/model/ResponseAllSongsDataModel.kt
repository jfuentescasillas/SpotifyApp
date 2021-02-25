package com.example.tarea004_spotifyapp.data.model

import java.io.Serializable


data class ResponseAllSongsDataModel(
    val href: String,
    val items: List<Song>,
    val limit: Int,
    val next: Any,
    val offset: Int,
    val previous: Any,
    val total: Int
)

data class Song(
    val added_at: String,
    val added_by: AddedBy,
    val is_local: Boolean,
    val primary_color: Any,
    val track: Track,
    val video_thumbnail: VideoThumbnail
)

data class AddedBy(
    val external_urls: ExternalUrls,
    val href: String,
    val id: String,
    val type: String,
    val uri: String
)

data class Track(
    val album: Album,
    val artists: List<ArtistX>,
    val available_markets: List<String>,
    val disc_number: Int,
    val duration_ms: Int,
    val episode: Boolean,
    val explicit: Boolean,
    val external_ids: ExternalIds,
    val external_urls: ExternalUrlsXXXX,
    val href: String,
    val id: String,
    val is_local: Boolean,
    val name: String,
    val popularity: Int,
    val preview_url: String,
    val track: Boolean,
    val track_number: Int,
    val type: String,
    val uri: String
)

data class VideoThumbnail(
    val url: Any
)

data class ExternalUrls(
    val spotify: String
)

data class Album(
    val album_type: String,
    val artists: List<Artist>,
    val available_markets: List<String>,
    val external_urls: ExternalUrlsXX,
    val href: String,
    val id: String,
    val images: List<Image>,
    val name: String,
    val release_date: String,
    val release_date_precision: String,
    val total_tracks: Int,
    val type: String,
    val uri: String
)

data class ArtistX(
    val external_urls: ExternalUrlsXXX,
    val href: String,
    val id: String,
    val name: String,
    val type: String,
    val uri: String
)

data class ExternalIds(
    val isrc: String
)

data class ExternalUrlsXXXX(
    val spotify: String
)

data class Artist(
    val external_urls: ExternalUrlsX,
    val href: String,
    val id: String,
    val name: String,
    val type: String,
    val uri: String
)

data class ExternalUrlsXX(
    val spotify: String
)

data class Image(
    val height: Int,
    val url: String,
    val width: Int
)

data class ExternalUrlsX(
    val spotify: String
)

data class ExternalUrlsXXX(
    val spotify: String
)

