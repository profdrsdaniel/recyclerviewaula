package com.example.recyclerviewaula.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recyclerviewaula.data.TodoRepository
import com.example.recyclerviewaula.data.model.Todo

class TodoViewModel : ViewModel() {
    private val repository = TodoRepository()

    private val _todolist = MutableLiveData<List<Todo>>()
    val todolist: LiveData<List<Todo>> = _todolist

    init {
        _todolist.value = repository.getTodos()
    }

    fun deleteTodo(todo: Todo) {
        val newList = repository.todoList
        newList.remove(todo)

        _todolist.value = newList.toList()
    }
}