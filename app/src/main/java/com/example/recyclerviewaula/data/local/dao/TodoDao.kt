package com.example.recyclerviewaula.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.recyclerviewaula.data.local.entities.TodoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: TodoEntity)

    @Query("SELECT * FROM todos")
    fun getAllTodos(): Flow<List<TodoEntity>>

    @Query("Update todos SET isCheck = :isCheck where id = :todoId")
    suspend fun checkTodo(todoId: Int, isCheck: Boolean)

    @Delete
    suspend fun delete(user: TodoEntity)
}