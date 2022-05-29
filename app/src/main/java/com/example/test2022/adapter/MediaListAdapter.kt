package com.example.test2022.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.test2022.databinding.ItemRowBinding
import com.example.test2022.diffutil.MediaDiffCallback
import com.example.test2022.model.MediaList


class MediaListAdapter constructor(private val context: Context, @NonNull diffCallback: MediaDiffCallback) : ListAdapter<MediaList, MediaListAdapter.ViewHolder?>(diffCallback){
    private lateinit var binding: ItemRowBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = ItemRowBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(@NonNull holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(@NonNull private val binding: ItemRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(mediaList: MediaList) {
            binding.tvName.text = mediaList.fileName

            if (mediaList.type == "image/png" || mediaList.type == "image/jpg"){
                binding.pbDownload.visibility = View.INVISIBLE
                Glide.with(context).load(mediaList.url).centerCrop().into(binding.ivThumbnail)
            }else{
                if(mediaList.imageUrl != null){
                    binding.pbDownload.visibility = View.INVISIBLE
                    Glide.with(context).load(mediaList.imageUrl).centerCrop().into(binding.ivThumbnail)
                }
            }

        }
    }


}