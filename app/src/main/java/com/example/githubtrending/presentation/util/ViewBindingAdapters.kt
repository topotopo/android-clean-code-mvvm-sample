/*
 * Copyright (c) 2020 by Maxine Micu.
 * All rights reserved.
 */

package com.example.githubtrending.presentation.util

import android.text.TextUtils
import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter

/**
 * Sets the TextView visibility to GONE if the text provided is null or empty.
 * If not, displays the text.
 *
 * @param view  the TextView to be displayed
 * @param text  the String to be set in the TextView
 */
@BindingAdapter("android:setTextAndVisibility")
fun setTextAndVisibility(view: TextView, text: String?) {
    if (TextUtils.isEmpty(text)) {
        view.visibility = View.GONE
    } else {
        view.visibility = View.VISIBLE
        view.text = text
    }
}