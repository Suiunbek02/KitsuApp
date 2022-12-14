package com.example.kitsuapp.models

import com.google.gson.annotations.SerializedName

data class LinksModel(

    @SerializedName("first")
    val first: String,

    @SerializedName("prev")
    val prev: String,

    @SerializedName("next")
    val next: String?,
)