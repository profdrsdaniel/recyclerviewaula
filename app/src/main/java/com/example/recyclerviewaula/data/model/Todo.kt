package com.example.recyclerviewaula.data.model

import java.io.Serializable

data class Todo(
    val id: Int,
    val title: String,
    val taskDescription: String,
    val check: Boolean,
    val createdAt: String,
    val openedBy: String
) : Serializable

