package com.ragabz.pokemongo.features.pokemonlist

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.github.nukc.LoadMoreWrapper.LoadMoreAdapter
import com.github.nukc.LoadMoreWrapper.LoadMoreWrapper
import com.ragabz.core.base.BaseDBFragment
import com.ragabz.pokemongo.R
import com.ragabz.pokemongo.databinding.FragmentPokemonListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokemonListFragment : BaseDBFragment<FragmentPokemonListBinding>(
    R.layout.fragment_pokemon_list
) {

    val viewModel: PokemonListViewModel by viewModels()


    override fun onInitBinding() {
        binding.apply {
            lifecycleOwner = this@PokemonListFragment
            viewModel = this@PokemonListFragment.viewModel
            fragment = this@PokemonListFragment
        }
        binding.button.setOnClickListener {
            viewModel.fetchRandomPokemonList()
        }
    }

    override fun onResume() {
        super.onResume()
        binding.recyclerView.adapter?.let {
            LoadMoreWrapper.with(it)
                .setShowNoMoreEnabled(true) // enable show NoMoreView，default false
                .setListener(object : LoadMoreAdapter.OnLoadMoreListener {
                    override fun onLoadMore(enabled: LoadMoreAdapter.Enabled?) {
                        viewModel.fetchRandomPokemonList()
                    }
                })
        }
    }

    fun onItemClick(index: Int) {
        val direction = PokemonListFragmentDirections.actionPokemonListToPokemonDetails(
            name = viewModel.getNameOfPokemonAtIndex(index),
            image = viewModel.getImageUrlAtIndex(index)
        )
        findNavController().navigate(direction)
    }
}
