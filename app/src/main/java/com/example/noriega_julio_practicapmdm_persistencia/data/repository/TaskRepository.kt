package com.example.noriega_julio_practicapmdm_persistencia.data.repository

import com.example.noriega_julio_practicapmdm_persistencia.data.model.Task
import com.example.noriega_julio_practicapmdm_persistencia.data.local.database.TaskDao

class TaskRepository(private val taskDao: TaskDao) {

    suspend fun addTask(task: Task) {
        taskDao.insert(task)
    }
}
