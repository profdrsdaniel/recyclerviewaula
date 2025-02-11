package com.example.recyclerviewaula.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.recyclerviewaula.data.model.Todo
import com.example.recyclerviewaula.databinding.FragmentFormTodoBinding
import com.example.recyclerviewaula.ui.viewmodel.TodoViewModel

class FormTodoFragment : Fragment() {
    private lateinit var binding: FragmentFormTodoBinding
    private val todoViewModel: TodoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFormTodoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addButton.setOnClickListener {
            val todo = Todo(
                title = binding.txvTitle.text.toString(),
                taskDescription = binding.txvDescription.text.toString(),
                openedBy = binding.txvUser.text.toString()
            )

            todoViewModel.addTodo(todo)
            val action = FormTodoFragmentDirections.actionFormTodoFragmentToListTodoFragment()
            findNavController().navigate(action)
        }
    }
}