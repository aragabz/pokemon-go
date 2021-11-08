package com.ragabz.pokemongo.binding

import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.github.florent37.glidepalette.BitmapPalette
import com.github.florent37.glidepalette.GlidePalette
import com.google.android.material.card.MaterialCardView
import com.ragabz.pokemongo.R
import timber.log.Timber

@BindingAdapter(value = ["imageUrl"], requireAll = false)
fun ImageView.loadImageFromUrl(imageUrl: String?) {
    // create request options to set placeholder or error
    val options = RequestOptions()
        .placeholder(R.color.white)
        .error(R.color.white)

    Glide.with(this.context)
        .setDefaultRequestOptions(options)
        .load(imageUrl ?: "")
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(this)
}

@BindingAdapter("paletteImage", "paletteCard")
fun bindLoadImagePalette(view: AppCompatImageView, url: String, paletteCard: MaterialCardView) {
    Timber.i("imageUrl: $url")
    Glide.with(view.context)
        .load(url)
        .listener(
            GlidePalette.with(url)
                .use(BitmapPalette.Profile.MUTED_LIGHT)
                .intoCallBack { palette ->
                    val rgb = palette?.dominantSwatch?.rgb
                    if (rgb != null) {
                        paletteCard.setCardBackgroundColor(rgb)
                    }
                }.crossfade(true)
        ).into(view)
}
