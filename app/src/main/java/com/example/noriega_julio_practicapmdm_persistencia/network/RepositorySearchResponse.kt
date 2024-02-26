package com.example.noriega_julio_practicapmdm_persistencia.network

import com.google.gson.annotations.SerializedName

data class RepositorySearchResponse(
    @SerializedName("total_count") val totalCount: Int,
    @SerializedName("incomplete_results") val incompleteResults: Boolean,
    @SerializedName("items") val items: List<Repository>
)
