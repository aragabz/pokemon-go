package com.ragabz.pokemongo.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MoveLearnMethod(
    @Json(name = "name")
    val name: String?,
    @Json(name = "url")
    val url: String?
)