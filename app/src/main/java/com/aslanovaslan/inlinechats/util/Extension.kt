package com.aslanovaslan.inlinechats.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.aslanovaslan.inlinechats.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("android:downloadUrlFromModel")
fun ImageView.downloadImage(url: Int) {
    val options = RequestOptions.placeholderOf(R.drawable.ic_ellipse_1)
        .error(R.drawable.ic_ellipse_1)
    Glide
        .with(context)
        .setDefaultRequestOptions(options)
        .load(url)
        .into(this);
}