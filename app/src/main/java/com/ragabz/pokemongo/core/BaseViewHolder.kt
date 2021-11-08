package com.ragabz.pokemongo.core

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

open class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var binding: ViewDataBinding? = null

    init {
        binding = DataBindingUtil.bind(view)
    }
}

open class BaseHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)