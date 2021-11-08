package com.ragabz.pokemongo.features.pokemondetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.ragabz.core.base.BaseDBFragment
import com.ragabz.pokemongo.R
import com.ragabz.pokemongo.databinding.FragmentPokemonDetailsBinding
import com.ragabz.pokemongo.databinding.FragmentPokemonListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokemonDetailsFragment : BaseDBFragment<FragmentPokemonDetailsBinding>(
    R.layout.fragment_pokemon_details
) {

    val viewModel: PokemonDetailsViewModel by viewModels()
    val args: PokemonDetailsFragmentArgs by navArgs()
    override fun onInitBinding() {
        val name = args.name
        val imageUrl = args.image
        viewModel.imageUrl.set(imageUrl)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = this@PokemonDetailsFragment.viewModel
        }
        viewModel.fetchPokemonInfo(name)
    }
}