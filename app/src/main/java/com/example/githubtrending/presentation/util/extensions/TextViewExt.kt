/*
 * Copyright (c) 2020 by Maxine Micu.
 * All rights reserved.
 */

package com.example.githubtrending.presentation.util.extensions

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.widget.TextView
import com.example.githubtrending.presentation.util.LanguageIconFactory.createCircleDrawable
import java.lang.IllegalArgumentException

/**
 * Creates a circular drawable and displays it at at the left side of the TextView.
 * @param colorHex  the color value in HEX of the drawable to be displayed,
 *                  if the colorHex is not valid, the default color is set to black.
 * @param padding   the spacing between the drawable and the text
 */
fun TextView.setLanguageIcon(colorHex: String, padding: Int) {
    val color = try {
        Color.parseColor(colorHex)
    } catch (e: IllegalArgumentException) {
        Color.BLACK
    }
    this.setCompoundDrawablesRelativeWithIntrinsicBounds(
        createCircleDrawable(
            ColorDrawable(color).color
        ),
        null,
        null,
        null
    )
    this.compoundDrawablePadding = padding
}

/**
 * Sets the size of a drawable and displays it at the left of the TextView
 * @param icon the drawable to display
 * @param padding the spacing between the set
 * @param size the size of the drawable
 */
fun TextView.addDrawableStartWithCustomSize(icon: Drawable?, padding: Int, size: Int) {
    if (icon == null) return

    icon.setBounds(0, 0, size, size)
    this.setCompoundDrawables(
        icon,
        null,
        null,
        null
    )
    this.compoundDrawablePadding = padding
}