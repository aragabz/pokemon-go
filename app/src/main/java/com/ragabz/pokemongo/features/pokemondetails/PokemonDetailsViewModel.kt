package com.ragabz.pokemongo.features.pokemondetails

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ragabz.pokemongo.core.onError
import com.ragabz.pokemongo.core.onSuccess
import com.ragabz.pokemongo.data.repositories.PokeRepository
import com.ragabz.pokemongo.models.PokemonInfoX
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class PokemonDetailsViewModel
@Inject
constructor(private val pokeRepository: PokeRepository) : ViewModel() {
    val pokemonInfo = ObservableField<PokemonInfoX>()
    val imageUrl = ObservableField<String>()


    fun fetchPokemonInfo(name: String) {
        viewModelScope.launch {
            pokeRepository.getPokemonInfo(name).collect {
                it.onSuccess {
                    pokemonInfo.set(it)
                }.onError {
                    Timber.e(it)
                }
            }
        }
    }
}
