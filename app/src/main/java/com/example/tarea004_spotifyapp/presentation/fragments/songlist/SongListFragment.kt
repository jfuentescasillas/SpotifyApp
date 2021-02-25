package com.example.tarea004_spotifyapp.presentation.fragments.songlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tarea004_spotifyapp.R
import com.example.tarea004_spotifyapp.base.util.BaseExtraData
import com.example.tarea004_spotifyapp.base.util.BaseState
import com.example.tarea004_spotifyapp.databinding.FragmentSongListBinding


class SongListFragment: Fragment() {
    lateinit var binding: FragmentSongListBinding
    private val viewModel: SongListViewModel by viewModels()
    lateinit var mAdapter: SongListAdapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSongListBinding.inflate(inflater, container, false)

        viewModel.getState().observe(viewLifecycleOwner) { state ->
            when (state) {
                is BaseState.Normal -> onNormal(state.data as SongListState)
                is BaseState.Loading -> onLoading(state.dataLoading)
                is BaseState.Error -> onError(state.dataError)
                else -> {}
            }
        }

        setupView()

        viewModel.requestPlayListInfo()

        return binding.root
    }


    private fun onLoading(dataLoading: BaseExtraData?) {

    }


    private fun onNormal(songListState: SongListState) {
        mAdapter.updateList(songListState.playList)
    }


    private fun onError(dataError: Throwable) {

    }


    private fun setupView() {
        mAdapter = SongListAdapter(listOf(), requireActivity()) { item ->
            Toast.makeText(requireActivity(), item.track.name, Toast.LENGTH_SHORT).show()
        }

        binding.fragmentListRecyclerview.apply {
            adapter = mAdapter
            layoutManager = GridLayoutManager(requireActivity(), 1)
            itemAnimator = DefaultItemAnimator()
        }
    }
}