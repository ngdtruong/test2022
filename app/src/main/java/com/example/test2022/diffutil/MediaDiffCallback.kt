package com.example.test2022.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.example.test2022.model.MediaList

class MediaDiffCallback: DiffUtil.ItemCallback<MediaList>() {
    override fun areItemsTheSame(oldItem: MediaList, newItem: MediaList): Boolean {
        return oldItem.orderId == oldItem.orderId
    }

    override fun areContentsTheSame(oldItem: MediaList, newItem: MediaList): Boolean {
        return oldItem == oldItem
    }
}