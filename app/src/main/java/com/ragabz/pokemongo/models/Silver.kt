package com.ragabz.pokemongo.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Silver(
    @Json(name = "back_default")
    val backDefault: Any?,
    @Json(name = "back_shiny")
    val backShiny: Any?,
    @Json(name = "front_default")
    val frontDefault: Any?,
    @Json(name = "front_shiny")
    val frontShiny: Any?
)