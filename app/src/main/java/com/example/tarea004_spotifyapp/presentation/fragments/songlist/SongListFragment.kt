package com.example.tarea004_spotifyapp.presentation.fragments.songlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.tarea004_spotifyapp.R
import com.example.tarea004_spotifyapp.databinding.FragmentSongListBinding


class SongListFragment: Fragment() {
    lateinit var binding: FragmentSongListBinding
    private val viewModel: SongListViewModel by viewModels()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentSongListBinding.inflate(inflater, container, false)

        return binding.root
    }
}