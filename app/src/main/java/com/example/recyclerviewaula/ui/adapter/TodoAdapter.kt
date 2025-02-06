package com.example.recyclerviewaula.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.recyclerviewaula.R
import com.example.recyclerviewaula.data.model.Todo

class TodoAdapter(
    private val onDelete: (Todo) -> Unit,
    private val onDetails: (Todo) -> Unit
) : ListAdapter<Todo, TodoViewHolder>(TodoDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.todo_item_list, parent, false)
        return TodoViewHolder(itemView = itemView, onDelete = onDelete, onDetails = onDetails)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}