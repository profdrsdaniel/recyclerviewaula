package com.example.recyclerviewaula.data

import com.example.recyclerviewaula.data.local.TodoLocalDataSource
import com.example.recyclerviewaula.data.mappers.convertToEntity
import com.example.recyclerviewaula.data.mappers.convertToModel
import com.example.recyclerviewaula.data.model.Todo
import kotlinx.coroutines.flow.map


class TodoRepository(private val dataSource: TodoLocalDataSource) {
    fun getAllTodos() =
        dataSource.getAllTodos().map { entities -> entities.map { it.convertToModel() } }

    suspend fun remove(todo: Todo) = dataSource.deleteTodo(todo.convertToEntity())
    suspend fun add(todo: Todo) = dataSource.addTodo(todo.convertToEntity())
    suspend fun checkTodo(todoId: Int, isCheck: Boolean) = dataSource.checkTodo(todoId, isCheck)
}