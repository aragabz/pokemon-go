package com.ragabz.pokemongo.data.remote

import com.ragabz.pokemongo.core.Result
import com.ragabz.pokemongo.extensions.toFlow
import com.ragabz.pokemongo.models.PokemonInfo
import com.ragabz.pokemongo.models.PokemonInfoX
import com.ragabz.pokemongo.models.PokemonResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokeRemoteDataSource
@Inject constructor(private val pokeApi: PokeApi) {

    suspend fun fetchPokemonList(
        offset: Int
    ): Flow<Result<PokemonResponse>> {
        return pokeApi.fetchPokemonList(offset = offset).toFlow()
    }

    suspend fun fetchPokemonInfo(name: String): Flow<Result<PokemonInfoX>> {
        return pokeApi.fetchPokemonInfo(name).toFlow()
    }
}
