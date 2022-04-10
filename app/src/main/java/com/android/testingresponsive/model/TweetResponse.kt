package com.android.testingresponsive.model

import com.google.gson.annotations.SerializedName

data class TweetResponse(
    @SerializedName("data")
    val `data`: List<Data>
)