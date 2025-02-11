package com.example.recyclerviewaula.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.recyclerviewaula.data.local.dao.TodoDao
import com.example.recyclerviewaula.data.local.entities.TodoEntity

@Database(entities = [TodoEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDao
}