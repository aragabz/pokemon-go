package com.ragabz.pokemongo.features.pokemonlist

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ragabz.pokemongo.core.onError
import com.ragabz.pokemongo.core.onSuccess
import com.ragabz.pokemongo.data.repositories.PokeRepository
import com.ragabz.pokemongo.models.Pokemon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val pokeRepository: PokeRepository
) : ViewModel() {

    val pokemonList = ObservableArrayList<Pokemon>()
    val isLoading = ObservableBoolean(false)

    init {
        fetchRandomPokemonList()
    }
    fun fetchRandomPokemonList() {
        isLoading.set(true)
        viewModelScope.launch {
            pokeRepository.fetchPokemonList(
                offset = Random.nextInt(0, 1000)
            ).collect {
                it.onSuccess {
                    // success
                    pokemonList.clear()
                    pokemonList.addAll(it.results)
                    isLoading.set(false)
                }.onError {
                    // show Error
                    Timber.e(it.message)
                    isLoading.set(false)
                }
            }
        }
    }

    fun getNameOfPokemonAtIndex(index: Int): String {
        return pokemonList[index]?.name ?: ""
    }
    fun getImageUrlAtIndex(index: Int): String {
        return pokemonList[index]?.getImageUrl() ?: ""
    }
}
