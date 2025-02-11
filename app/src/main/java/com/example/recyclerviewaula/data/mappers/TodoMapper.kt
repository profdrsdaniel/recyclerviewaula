package com.example.recyclerviewaula.data.mappers

import com.example.recyclerviewaula.data.local.entities.TodoEntity
import com.example.recyclerviewaula.data.model.Todo

fun Todo.convertToEntity() =
    TodoEntity(
        id = this.id,
        title = this.title,
        taskDescription = this.taskDescription,
        createdAt = this.createdAt,
        openedBy = this.openedBy,
        isCheck = this.check
    )

fun TodoEntity.convertToModel() =
    Todo(
        id = this.id,
        title = this.title,
        taskDescription = this.taskDescription,
        createdAt = this.createdAt,
        openedBy = this.openedBy,
        check = this.isCheck
    )