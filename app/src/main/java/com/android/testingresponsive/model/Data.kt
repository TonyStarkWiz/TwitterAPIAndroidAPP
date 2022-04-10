package com.android.testingresponsive.model

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("username")
    val username: String
)