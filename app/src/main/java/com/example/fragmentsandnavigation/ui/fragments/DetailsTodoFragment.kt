package com.example.fragmentsandnavigation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.fragmentsandnavigation.R

class DetailsTodoFragment : Fragment() {
    val args: DetailsTodoFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details_todo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val todo = args.todo

        view.findViewById<TextView>(R.id.idTodo).text = todo.id.toString()
        view.findViewById<TextView>(R.id.todoTitle).text = todo.title
        view.findViewById<TextView>(R.id.taskDescription).text = todo.taskDescription
        view.findViewById<TextView>(R.id.createdAt).text = todo.createdAt
        view.findViewById<TextView>(R.id.openedBy).text = todo.openedBy
    }
}