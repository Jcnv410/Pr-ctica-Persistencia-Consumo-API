package com.example.noriega_julio_practicapmdm_persistencia.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface TaskApi {

    // Define métodos para realizar solicitudes HTTP

    @GET("search/repositories")
    suspend fun searchRepositories(
        @Query("q") query: String // Query para buscar repositorios
    ): RepositorySearchResponse

    companion object {
        fun create(): TaskApi {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://developer.todoist.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(TaskApi::class.java)
        }
    }
}