package com.example.githubtrending.presentation.common

import androidx.fragment.app.Fragment
import com.example.githubtrending.presentation.util.NavigatorHelper
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
open class BaseFragment : Fragment() {

    @Inject
    lateinit var navigation: NavigatorHelper

    /**
     * Inflates an error dialog.
     */
    fun showErrorDialog() {
        val errorDialog =
            ErrorDialog()
        errorDialog.show(parentFragmentManager, "error")
    }
}