package com.example.tarea004_spotifyapp.presentation.fragments.songlist

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tarea004_spotifyapp.R
import com.example.tarea004_spotifyapp.data.model.Song
import com.example.tarea004_spotifyapp.databinding.ItemSongListBinding
import com.example.tarea004_spotifyapp.databinding.ItemSongListBinding.inflate


class SongListAdapter(private var dataSet: List<Song>, private val context: Context, private val callback: (item: Song) -> Unit): RecyclerView.Adapter<SongListAdapter.ViewHolder>() {
    class ViewHolder(val binding: ItemSongListBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(inflate(LayoutInflater.from(viewGroup.context), viewGroup, false))
    }


    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = dataSet[position]

        viewHolder.binding.apply {

            itemSongTxtViewName.text = item.track.name
            itemSongTxtViewArtist.text = item.track.artists[0].name
            itemSongTxtViewAlbum.text = item.track.album.name

            var url = item.track.album.images[1].url

            Glide.with(context)
                .load(url?: R.drawable.ic_404)
                .fitCenter()
                .placeholder(R.drawable.ic_404)
                .into(itemSongImageView)
        }

        viewHolder.itemView.setOnClickListener {
            callback.invoke(item)
        }
    }

    override fun getItemCount() = dataSet.size

    fun updateList(newList: List<Song>) {
        dataSet = newList
        notifyDataSetChanged()
    }
}