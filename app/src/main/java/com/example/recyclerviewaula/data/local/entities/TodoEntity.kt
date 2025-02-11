package com.example.recyclerviewaula.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todos")
data class TodoEntity(
    @PrimaryKey(autoGenerate = true)

    val id: Int = 0,
    val title: String = "",
    val taskDescription: String = "",
    val isCheck: Boolean = false,
    val createdAt: String = "10/02/2025",
    val openedBy: String = "Daniel"
)
