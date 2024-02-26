package com.example.noriega_julio_practicapmdm_persistencia.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.noriega_julio_practicapmdm_persistencia.data.model.Task
import com.example.noriega_julio_practicapmdm_persistencia.data.repository.TaskRepository
import com.example.noriega_julio_practicapmdm_persistencia.network.TaskApi
import com.example.noriega_julio_practicapmdm_persistencia.network.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException

class TaskViewModel(private val taskRepository: TaskRepository) : ViewModel() {

    private val _searchResults = MutableLiveData<List<Repository>>()
    val searchResults: LiveData<List<Repository>> = _searchResults

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun searchRepositories(query: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = TaskApi.create().searchRepositories(query)
                _searchResults.postValue(response.items)
            } catch (e: HttpException) {
                _error.postValue("Error al realizar la solicitud: ${e.message()}")
            } catch (e: Throwable) {
                _error.postValue("Error inesperado: ${e.message}")
            }
        }
    }

    fun addTask(task: Task, onSuccess: () -> Unit, onError: (String) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                taskRepository.addTask(task)
            } catch (e: Exception) {
                onError("Failed to add task: ${e.message}")
            }
        }
    }


}
