package com.ragabz.pokemongo.features.pokemonlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.RecyclerView
import com.ragabz.pokemongo.R
import com.ragabz.pokemongo.core.BaseViewHolder
import com.ragabz.pokemongo.databinding.ItemPokemonBinding
import com.ragabz.pokemongo.models.Pokemon

class PokemonListAdapters(
    var items: ObservableArrayList<Pokemon>,
    var fragment: PokemonListFragment
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding: ItemPokemonBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_pokemon,
                parent,
                false
            )
        return PokemonItemViewHolder(binding.root)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is PokemonItemViewHolder) {
            val itemBinding = holder.binding as ItemPokemonBinding
            // itemBinding.imageViewChannelSubscribe.onClick {
            //     fragment.onSubscribeClick(position)
            // }
            itemBinding.root.setOnClickListener {
                fragment.onItemClick(position)
            }
            itemBinding.apply {
                pokemon = items[position]
                executePendingBindings()
            }

        }
    }
}

class PokemonItemViewHolder(view: View) : BaseViewHolder(view)

@BindingAdapter("pokemonList", "fragment")
fun bindChannelsList(
    recyclerView: RecyclerView,
    items: ObservableArrayList<Pokemon>,
    fragment: PokemonListFragment
) {
    var adapter: PokemonListAdapters? = recyclerView.adapter as PokemonListAdapters?
    if (adapter == null) {
        adapter = PokemonListAdapters(items, fragment)
        recyclerView.adapter = adapter
    }
    adapter.notifyDataSetChanged()
}
