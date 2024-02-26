package com.example.noriega_julio_practicapmdm_persistencia.network

import com.google.gson.annotations.SerializedName

data class Repository(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("full_name") val fullName: String,
)
