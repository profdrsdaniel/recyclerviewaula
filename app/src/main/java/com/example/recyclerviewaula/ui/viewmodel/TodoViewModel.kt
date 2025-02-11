package com.example.recyclerviewaula.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.recyclerviewaula.data.TodoRepository
import com.example.recyclerviewaula.data.model.Todo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(
    private val repository: TodoRepository
) : ViewModel() {
    private var _todolist = repository.getAllTodos().asLiveData()
    val todolist: LiveData<List<Todo>> = _todolist

    init {
        repository.getAllTodos()
    }

    fun removeTodo(todo: Todo) = viewModelScope.launch(Dispatchers.IO) {
        repository.remove(todo)
    }

    fun addTodo(todo: Todo) = viewModelScope.launch(Dispatchers.IO) {
        repository.add(todo)
    }

    fun checkTodo(todoId: Int, isCheck: Boolean) = viewModelScope.launch(Dispatchers.IO) {
        repository.checkTodo(todoId, isCheck)
    }
}