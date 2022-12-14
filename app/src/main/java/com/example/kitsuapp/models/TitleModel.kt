package com.example.kitsuapp.models

import com.google.gson.annotations.SerializedName

data class TitleModel(

    @SerializedName("ja_jp")
    val ja_jp: String?,

    @SerializedName("en_jp")
    val en_jp: String?

)
