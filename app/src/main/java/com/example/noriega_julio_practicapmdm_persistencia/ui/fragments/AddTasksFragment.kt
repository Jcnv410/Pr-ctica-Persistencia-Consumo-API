package com.example.noriega_julio_practicapmdm_persistencia.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.noriega_julio_practicapmdm_persistencia.R
import com.example.noriega_julio_practicapmdm_persistencia.data.local.database.TaskDatabase
import com.example.noriega_julio_practicapmdm_persistencia.data.model.Task
import com.example.noriega_julio_practicapmdm_persistencia.data.repository.TaskRepository
import com.example.noriega_julio_practicapmdm_persistencia.ui.viewmodels.TaskViewModel
import com.example.noriega_julio_practicapmdm_persistencia.ui.viewmodels.TaskViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddTasksFragment : Fragment() {

    private lateinit var taskViewModel: TaskViewModel
    private lateinit var titleEditText: EditText
    private lateinit var descriptionEditText: EditText
    private lateinit var moduleRadioGroup: RadioGroup
    private lateinit var addButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_tasks, container, false)

        titleEditText = view.findViewById(R.id.editTextTitle)
        descriptionEditText = view.findViewById(R.id.editTextDescription)
        moduleRadioGroup = view.findViewById(R.id.radioGroupModule)
        addButton = view.findViewById(R.id.buttonAddTask)

        val taskDao = TaskDatabase.getDatabase(requireContext()).taskDao()
        val taskRepository = TaskRepository(taskDao)
        val viewModelFactory = TaskViewModelFactory(taskRepository)
        taskViewModel = ViewModelProvider(this, viewModelFactory).get(TaskViewModel::class.java)

        addButton.setOnClickListener {
            addTask()
        }

        return view
    }

    private fun addTask() {
        val title = titleEditText.text.toString().trim()
        val description = descriptionEditText.text.toString().trim()
        val selectedModuleRadioButtonId = moduleRadioGroup.checkedRadioButtonId
        val selectedModuleRadioButton = view?.findViewById<RadioButton>(selectedModuleRadioButtonId)
        val module = selectedModuleRadioButton?.text?.toString()?.trim()

        if (title.isEmpty() || description.isEmpty() || module.isNullOrEmpty()) {
            showToast("Please fill out all fields")
            return
        }

        val newTask = Task(title = title, description = description, moduleId = 1)

        CoroutineScope(Dispatchers.IO).launch {
            taskViewModel.addTask(
                newTask,
                onSuccess = {
                    showToast("Task added successfully")
                    clearInputFields()
                },
                onError = { errorMessage ->
                    showToast("Failed to add task: $errorMessage")
                }
            )
        }

    }

    private fun showToast(message: String) {
        requireActivity().runOnUiThread {
            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
        }
    }


    private fun clearInputFields() {
        titleEditText.text.clear()
        descriptionEditText.text.clear()
        moduleRadioGroup.clearCheck()
    }
}
