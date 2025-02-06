package com.example.recyclerviewaula.ui.adapter

import android.graphics.Paint
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewaula.R
import com.example.recyclerviewaula.data.model.Todo
import com.google.android.material.checkbox.MaterialCheckBox

class TodoViewHolder(
    itemView: View,
    private val onDelete: (Todo) -> Unit,
    private val onDetails: (Todo) -> Unit
) : RecyclerView.ViewHolder(itemView) {
    private val title: TextView = itemView.findViewById(R.id.titleTodo)
    private val taskDescription: TextView = itemView.findViewById(R.id.todoTaskDescription)
    private val todoCheck: MaterialCheckBox = itemView.findViewById(R.id.todoCheck)
    private val actionDelete: TextView = itemView.findViewById(R.id.actionDelete)
    private val actionDetails: TextView = itemView.findViewById(R.id.actionDetails)

    fun bind(todo: Todo) {
        title.text = todo.title
        taskDescription.text = todo.taskDescription
        todoCheck.isChecked = todo.check

        actionDelete.setOnClickListener {
            onDelete(todo)
        }

        actionDetails.setOnClickListener {
            onDetails(todo)
        }
        doPaintTask()
        paintTaskChecked()
    }

    private fun paintTaskChecked() {
        this.todoCheck.addOnCheckedStateChangedListener { checkBox, state ->
            if (checkBox.isChecked) {
                this.title.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
                this.taskDescription.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
                this.actionDetails.visibility = View.GONE
                this.actionDelete.visibility = View.GONE
            } else {
                this.title.paintFlags = 0
                this.taskDescription.paintFlags = 0
                this.actionDetails.visibility = View.VISIBLE
                this.actionDelete.visibility = View.VISIBLE
            }
        }
    }

    private fun doPaintTask() {
        if (this.todoCheck.isChecked) {
            this.title.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            this.taskDescription.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            this.actionDetails.visibility = View.GONE
            this.actionDelete.visibility = View.GONE
        } else {
            this.title.paintFlags = 0
            this.taskDescription.paintFlags = 0
            this.actionDetails.visibility = View.VISIBLE
            this.actionDelete.visibility = View.VISIBLE
        }
    }
}