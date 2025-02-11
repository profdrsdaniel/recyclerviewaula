package com.example.recyclerviewaula.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.recyclerviewaula.databinding.FragmentDetailsTodoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsTodoFragment : Fragment() {
    private lateinit var binding: FragmentDetailsTodoBinding
    val args: DetailsTodoFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsTodoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val todoArgs = args.todo
        binding.todo = todoArgs
    }
}