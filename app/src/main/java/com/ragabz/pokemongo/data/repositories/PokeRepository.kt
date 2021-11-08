package com.ragabz.pokemongo.data.repositories

import com.ragabz.pokemongo.core.Result
import com.ragabz.pokemongo.data.remote.PokeRemoteDataSource
import com.ragabz.pokemongo.models.PokemonInfo
import com.ragabz.pokemongo.models.PokemonInfoX
import com.ragabz.pokemongo.models.PokemonResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokeRepository
@Inject constructor(
    private val pokeRemoteDataSource: PokeRemoteDataSource
) {

    suspend fun fetchPokemonList(offset: Int): Flow<Result<PokemonResponse>> {
        return pokeRemoteDataSource.fetchPokemonList(offset = offset)
    }

    suspend fun getPokemonInfo(name: String): Flow<Result<PokemonInfoX>> {
        return pokeRemoteDataSource.fetchPokemonInfo(name)
    }
}
