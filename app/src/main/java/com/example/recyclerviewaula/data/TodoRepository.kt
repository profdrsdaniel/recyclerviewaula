package com.example.recyclerviewaula.data

import com.example.recyclerviewaula.data.local.TodoLocalDataSource
import com.example.recyclerviewaula.data.mappers.convertToEntity
import com.example.recyclerviewaula.data.mappers.convertToModel
import com.example.recyclerviewaula.data.model.Todo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface TodoRepository {
    fun getAllTodos(): Flow<List<Todo>>
    suspend fun remove(todo: Todo)
    suspend fun add(todo: Todo)
    suspend fun checkTodo(todoId: Int, isCheck: Boolean)
}

class TodoRepositoryImpl @Inject constructor(private val dataSource: TodoLocalDataSource) : TodoRepository {
    override fun getAllTodos(): Flow<List<Todo>> =
        dataSource.getAllTodos().map { entities -> entities.map { it.convertToModel() } }


    override suspend fun remove(todo: Todo) {
        dataSource.deleteTodo(todo.convertToEntity())
    }

    override suspend fun add(todo: Todo) {
        dataSource.addTodo(todo.convertToEntity())
    }

    override suspend fun checkTodo(todoId: Int, isCheck: Boolean) {
       dataSource.checkTodo(todoId, isCheck)
    }

}