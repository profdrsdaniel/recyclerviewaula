package com.example.recyclerviewaula.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewaula.data.model.Todo
import com.example.recyclerviewaula.databinding.TodoItemListBinding

class TodoViewHolder(
    private val binding: TodoItemListBinding,
    private val onDelete: (Todo) -> Unit,
    private val onDetails: (Todo) -> Unit,
    private val onCheck: (Todo) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(todo: Todo) {
        binding.todo = todo

        binding.actionDelete.setOnClickListener {
            onDelete(todo)
        }

        binding.actionDetails.setOnClickListener {
            onDetails(todo)
        }

        binding.todoCheck.addOnCheckedStateChangedListener { check, _ ->
            val newTodo = todo.copy(check = check.isChecked)
            binding.todo = newTodo
            onCheck(newTodo)
        }
    }
}