package com.example.kitsuapp.models

import com.google.gson.annotations.SerializedName

data class AttributesModel(

    @SerializedName("titles")
    val title: TitleModel,

    @SerializedName("posterImage")
    val posterImage: PosterImageModel
)
