package com.example.kitsuapp.models

import com.google.gson.annotations.SerializedName

data class KitsuResponce <T>(

    @SerializedName("data")
    val data : List<T>,

    @SerializedName("links")
    val links: LinksModel

)