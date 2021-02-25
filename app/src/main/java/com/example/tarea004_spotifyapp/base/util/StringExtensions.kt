package com.example.tarea004_spotifyapp.base.util

import android.util.Base64

class StringExtensions {
    // Extension of String that allows to encode into Base64
    fun String.toBase64(): String = Base64.encodeToString(this.toByteArray(charset("UTF-8")), Base64.DEFAULT)
}