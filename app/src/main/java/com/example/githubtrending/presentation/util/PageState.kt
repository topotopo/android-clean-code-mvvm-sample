package com.example.githubtrending.presentation.util

sealed class PageState {
    object Loading : PageState()
    object Success : PageState()
    data class Error(val message: String) : PageState()
}