package com.ragabz.pokemongo.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlin.random.Random

@JsonClass(generateAdapter = true)
data class PokemonInfoX(
    @Json(name = "abilities")
    val abilities: List<Ability>?,
    @Json(name = "base_experience")
    val baseExperience: Int?,
    @Json(name = "forms")
    val forms: List<Form>?,
    @Json(name = "game_indices")
    val gameIndices: List<GameIndice>?,
    @Json(name = "height")
    val height: Int?,
    @Json(name = "held_items")
    val heldItems: List<HeldItem>?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "is_default")
    val isDefault: Boolean?,
    @Json(name = "location_area_encounters")
    val locationAreaEncounters: String?,
    @Json(name = "moves")
    val moves: List<Move>?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "order")
    val order: Int?,
    @Json(name = "past_types")
    val pastTypes: List<Any>?,
    @Json(name = "species")
    val species: Species?,
    @Json(name = "sprites")
    val sprites: Sprites?,
    @Json(name = "stats")
    val stats: List<Stat>?,
    @Json(name = "types")
    val types: List<Type>?,
    @Json(name = "weight")
    val weight: Int?
) {
    val speed: Int = Random.nextInt(maxSpeed)
    fun getIdString(): String = String.format("#%03d", id)
    fun getWeightString(): String = String.format("%.1f KG", weight?.toFloat() ?: 0 / 10)
    fun getHeightString(): String = String.format("%.1f M", height?.toFloat() ?: 0 / 10)

    fun getSpeedString(): String = "$speed/${PokemonInfo.maxSpeed}"

    fun getMovesString(): String {
        var movesValue = ""
        moves?.forEach {
            movesValue += "${it.move?.name} , "
        }
        return movesValue
    }

    fun getImageUrl(): String {
        return sprites?.frontDefault ?: ""
    }

    companion object {
        const val maxHp = 300
        const val maxAttack = 300
        const val maxDefense = 300
        const val maxSpeed = 300
        const val maxExp = 1000
    }
}