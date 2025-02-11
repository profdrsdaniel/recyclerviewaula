package com.example.recyclerviewaula.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.recyclerviewaula.data.TodoRepository
import com.example.recyclerviewaula.data.local.TodoLocalDataSource
import com.example.recyclerviewaula.data.local.database.AppDatabase
import com.example.recyclerviewaula.data.model.Todo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoViewModel(application: Application) : AndroidViewModel(application) {
    // TODO está da pior forma até a próxima aula
    private val todoDao = AppDatabase.getInstance(application).todoDao()
    private val localDataSource = TodoLocalDataSource(todoDao)
    private val repository = TodoRepository(localDataSource)

    private val _todolist = repository.getAllTodos().asLiveData()
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