package com.ragabz.pokemongo.data.remote

import com.ragabz.pokemongo.models.PokemonInfo
import com.ragabz.pokemongo.models.PokemonInfoX
import com.ragabz.pokemongo.models.PokemonResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApi {

    @GET("pokemon")
    suspend fun fetchPokemonList(
        @Query("limit") limit: Int = 20,
        @Query("offset") offset: Int = 0
    ): Response<PokemonResponse>

    @GET("pokemon/{name}")
    suspend fun fetchPokemonInfo(@Path("name") name: String): Response<PokemonInfoX>
}
