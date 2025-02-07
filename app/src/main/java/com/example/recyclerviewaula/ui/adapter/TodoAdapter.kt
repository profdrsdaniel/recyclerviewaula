package com.example.recyclerviewaula.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.recyclerviewaula.R
import com.example.recyclerviewaula.data.model.Todo
import com.example.recyclerviewaula.databinding.TodoItemListBinding

class TodoAdapter(
    private val onDelete: (Todo) -> Unit,
    private val onDetails: (Todo) -> Unit,
    private val onCheck: (Todo) -> Unit
) : ListAdapter<Todo, TodoViewHolder>(TodoDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding =
            TodoItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodoViewHolder(
            binding = binding,
            onDelete = onDelete,
            onDetails = onDetails,
            onCheck = onCheck
        )
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}