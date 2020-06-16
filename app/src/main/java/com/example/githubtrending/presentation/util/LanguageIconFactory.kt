/*
 * Copyright (c) 2020 by Maxine Micu.
 * All rights reserved.
 */

package com.example.githubtrending.presentation.util

import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape

object LanguageIconFactory {

    /**
     * Returns an circle shaped drawable for the
     *
     * @param color the color in hex format
     */
    fun createCircleDrawable(color: Int): ShapeDrawable {
        val shape = ShapeDrawable(OvalShape())
        shape.intrinsicHeight = 25
        shape.intrinsicWidth = 25
        shape.paint.color = color

        return shape
    }
}
