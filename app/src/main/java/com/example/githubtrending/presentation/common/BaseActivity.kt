package com.example.githubtrending.presentation.common

import androidx.appcompat.app.AppCompatActivity
import com.example.githubtrending.presentation.util.NavigatorHelper
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import javax.inject.Inject

@AndroidEntryPoint
@WithFragmentBindings
open class BaseActivity : AppCompatActivity() {

    @Inject
    lateinit var navigation: NavigatorHelper
}