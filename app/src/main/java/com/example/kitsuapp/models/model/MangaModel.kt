package com.example.kitsuapp.models.model

import com.example.kitsuapp.base.BaseDiffUtil
import com.example.kitsuapp.models.AttributesModel
import com.google.gson.annotations.SerializedName

data class MangaModel(
    @SerializedName("id")
    override val id: Int,

    @SerializedName("type")
    val type: String,

    @SerializedName("attributes")
    val attributes: AttributesModel

) : BaseDiffUtil