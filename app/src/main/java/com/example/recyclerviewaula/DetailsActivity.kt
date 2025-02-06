package com.example.recyclerviewaula

import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.recyclerviewaula.data.model.Todo

class DetailsActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val id = findViewById<TextView>(R.id.idTodo)
        val title = findViewById<TextView>(R.id.todoTitle)
        val description = findViewById<TextView>(R.id.taskDescription)
        val date = findViewById<TextView>(R.id.createdAt)
        val user = findViewById<TextView>(R.id.openedBy)

        intent.extras?.getSerializable("todo", Todo::class.java).also {
            it?.let {
                id.text = it.id.toString()
                title.text = it.title
                description.text = it.taskDescription
                date.text = it.createdAt
                user.text = it.openedBy
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}