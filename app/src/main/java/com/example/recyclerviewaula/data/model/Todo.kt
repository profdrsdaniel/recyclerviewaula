package com.example.recyclerviewaula.data.model

import java.io.Serializable

data class Todo(
    val id: Int = 0,
    val title: String = "",
    val taskDescription: String = "",
    val check: Boolean = false,
    val createdAt: String  = "20/02/2025",
    val openedBy: String = ""
) : Serializable

