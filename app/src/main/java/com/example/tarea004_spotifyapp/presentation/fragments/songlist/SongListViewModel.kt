package com.example.tarea004_spotifyapp.presentation.fragments.songlist

import com.example.tarea004_spotifyapp.base.util.BaseState
import com.example.tarea004_spotifyapp.base.util.NetworkManager
import com.example.tarea004_spotifyapp.base.util.NoInternetConnectivity
import com.example.tarea004_spotifyapp.data.SongRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import android.app.Application
import androidx.lifecycle.*


class SongListViewModel(app: Application): AndroidViewModel(app) {
    private val state =  MutableLiveData<BaseState>()
    fun getState(): LiveData<BaseState> = state


    fun requestPlayListInfo() {
        val hasInternetConnection: Boolean = NetworkManager().isNetworkAvailable(getApplication())
        if (hasInternetConnection) {
            viewModelScope.launch(Dispatchers.IO) {
                try {
                    state.postValue(BaseState.Loading())
                    val response = SongRepository().getSongList()
                    state.postValue(BaseState.Normal(SongListState(response)))
                } catch (e: Exception) {
                    state.postValue(BaseState.Error(e))
                }
            }
        } else {
            state.postValue(BaseState.Error(NoInternetConnectivity()))
        }
    }
}