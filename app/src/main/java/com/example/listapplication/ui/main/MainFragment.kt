package com.example.listapplication.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.listapplication.R
import com.example.listapplication.ui.main.adapter.DataAdapter
import com.example.listapplication.viewmodel.MainViewModel

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view =  inflater.inflate(R.layout.fragment_main, container, false)
        viewModel = ViewModelProvider(requireActivity(), defaultViewModelProviderFactory)[MainViewModel::class.java]
        val recyclerview = view.findViewById<RecyclerView>(R.id.list)
        recyclerview.layoutManager = LinearLayoutManager(requireContext())

        val adapter = DataAdapter()
        recyclerview.adapter = adapter

        viewModel.dataList.observe(viewLifecycleOwner) {
            adapter.list = it
        }
        return view
    }

}