/*
 * Copyright (c) 2020 by Maxine Micu.
 * All rights reserved.
 */

package com.example.githubtrending.presentation.util.extensions

import android.content.Context

fun Float.convertDpToInt(context: Context): Int {
    return (this * context.resources.displayMetrics.density).toInt()
}
