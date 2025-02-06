package com.example.recyclerviewaula

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewaula.data.TodoRepository
import com.example.recyclerviewaula.data.model.Todo
import com.example.recyclerviewaula.ui.adapter.TodoAdapter
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private val repository = TodoRepository()
    private lateinit var adapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rc = findViewById<RecyclerView>(R.id.recyclerView)
        adapter = TodoAdapter(
            onDelete = { todo ->
                deleteTodo(rc, todo)
            },
            onDetails = { todo ->
                goToDetails(todo = todo)
            }
        )
        rc.adapter = adapter

        adapter.submitList(repository.todoList)
    }

    private fun deleteTodo(recyclerView: RecyclerView, todo: Todo) {
        val newList = repository.todoList.toMutableList()
        newList.remove(todo)
        adapter.submitList(newList)

        Snackbar.make(this, recyclerView, "Deletado com Sucesso", Snackbar.LENGTH_LONG).show()
    }

    private fun goToDetails(todo: Todo) {
        val intent = Intent(this, DetailsActivity::class.java).apply {
            this.putExtras(bundleOf("todo" to todo))
        }
        startActivity(intent)
    }
}