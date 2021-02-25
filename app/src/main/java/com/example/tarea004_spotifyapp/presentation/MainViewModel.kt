package com.example.tarea004_spotifyapp.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tarea004_spotifyapp.data.AuthenticationRepository
import kotlinx.coroutines.launch
import java.lang.Exception


class MainViewModel: ViewModel() {
    fun requestAuthenticationInformation(){
        viewModelScope.launch {
            try {
                val result = AuthenticationRepository().getAuthenticationToken()
                Log.e("AuthSuccess", result.toString())
            } catch (e: Exception){
                Log.e("Error", e.toString())
            }
        }
    }
}