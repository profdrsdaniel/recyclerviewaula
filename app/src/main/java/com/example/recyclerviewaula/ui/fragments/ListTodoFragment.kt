package com.example.recyclerviewaula.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewaula.R
import com.example.recyclerviewaula.data.model.Todo
import com.example.recyclerviewaula.ui.adapter.TodoAdapter
import com.example.recyclerviewaula.ui.viewmodel.TodoViewModel
import com.google.android.material.snackbar.Snackbar

class ListTodoFragment : Fragment() {

    private lateinit var adapter: TodoAdapter
    private val todoViewModel: TodoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        todoViewModel.todolist.observe(viewLifecycleOwner) { todo ->
            adapter.submitList(todo.toMutableList())
        }

        return inflater.inflate(R.layout.fragment_list_todo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rc = view.findViewById<RecyclerView>(R.id.recyclerView)
        adapter = TodoAdapter(
            onDelete = { todo ->
                todoViewModel.deleteTodo(todo)
            },
            onDetails = { todo ->
                goToDetails(todo = todo)
            }
        )
        rc.adapter = adapter
    }

    private fun goToDetails(todo: Todo) {
        val action = ListTodoFragmentDirections.actionListTodoFragmentToDetailsTodoFragment(todo)
        findNavController().navigate(action)
    }
}