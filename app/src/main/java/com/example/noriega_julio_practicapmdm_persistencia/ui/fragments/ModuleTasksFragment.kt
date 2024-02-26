package com.example.noriega_julio_practicapmdm_persistencia.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.noriega_julio_practicapmdm_persistencia.R
import com.example.noriega_julio_practicapmdm_persistencia.data.model.Task
import com.example.noriega_julio_practicapmdm_persistencia.ui.adapters.TaskAdapter

class ModuleTasksFragment : Fragment() {

    private lateinit var taskAdapter: TaskAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_module_tasks, container, false)

        val tasks = mutableListOf(
            Task(1, "Módulo 1", "Limpiar la casa", 2),
            Task(2, "Módulo 2", "Preparar la comida", 3),
            Task(3, "Módulo 3", "Hacer la compra", 1),
            Task(4, "Módulo 4", "Estudiar matemáticas", 1)
        )


        val recyclerView: RecyclerView = rootView.findViewById(R.id.tasksRecyclerView)
        taskAdapter = TaskAdapter(tasks)
        recyclerView.adapter = taskAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        return rootView
    }
}