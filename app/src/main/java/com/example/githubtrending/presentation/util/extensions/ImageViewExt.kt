/*
 * Copyright (c) 2020 by Maxine Micu.
 * All rights reserved.
 */

package com.example.githubtrending.presentation.util.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

/**
 * Loads the [url] in the [ImageView] and crops the shape to Circle. Uses Glide library.
 * @param url   the image url to load in the ImageView
 */
fun ImageView.loadCircularAvatar(url: String) {
    Glide.with(context).load(url)
        .apply(RequestOptions.circleCropTransform())
        .into(this)
}