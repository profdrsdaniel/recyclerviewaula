package com.example.fragmentsandnavigation.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.fragmentsandnavigation.data.model.Todo

class TodoDiffCallback : DiffUtil.ItemCallback<Todo>() {
    override fun areItemsTheSame(oldItem: Todo, newItem: Todo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Todo, newItem: Todo): Boolean {
        return oldItem == newItem
    }
}