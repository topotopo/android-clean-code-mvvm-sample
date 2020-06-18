package com.example.githubtrending.presentation.util

/**
 * Defines the state of screens (activity / fragment)
 */
sealed class PageState {
    object Loading : PageState()
    object Success : PageState()
    data class Error(val message: String) : PageState()
}