package com.example.recyclerviewaula.data.local

import com.example.recyclerviewaula.data.local.dao.TodoDao
import com.example.recyclerviewaula.data.local.entities.TodoEntity
import kotlinx.coroutines.flow.Flow

class TodoLocalDataSource(private val todoDao: TodoDao) {
    fun getAllTodos(): Flow<List<TodoEntity>> = todoDao.getAllTodos()

    suspend fun addTodo(todo: TodoEntity) {
        todoDao.insert(todo)
    }

    suspend fun deleteTodo(user: TodoEntity) {
        todoDao.delete(user)
    }

    suspend fun checkTodo(todoId: Int, isCheck: Boolean) {
        todoDao.checkTodo(todoId, !isCheck)
    }
}