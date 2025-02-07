package com.example.fragmentsandnavigation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentsandnavigation.R
import com.example.fragmentsandnavigation.data.TodoRepository
import com.example.fragmentsandnavigation.ui.adapter.TodoAdapter
import com.google.android.material.snackbar.Snackbar

class ListTodoFragment : Fragment() {
    private val todoRepository = TodoRepository()
    private lateinit var adapter: TodoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_todo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)

        adapter = TodoAdapter(
            onDelete = { todo ->
                Snackbar.make(
                    view.context,
                    recyclerView,
                    "Deletado com sucesso!",
                    Snackbar.LENGTH_SHORT
                ).show()

                val newList = todoRepository.todoList.toMutableList()
                newList.remove(todo)

                todoRepository.todoList = newList
                adapter.submitList(newList)
            },
            onDetails = { todo ->
                val action =
                    ListTodoFragmentDirections.actionListTodoFragmentToDetailsTodoFragment(todo)

                findNavController().navigate(action)
            }
        )

        recyclerView.adapter = adapter
        adapter.submitList(todoRepository.todoList)
    }
}