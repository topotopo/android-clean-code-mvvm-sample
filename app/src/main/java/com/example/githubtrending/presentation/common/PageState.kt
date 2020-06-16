package com.example.githubtrending.presentation.common

sealed class PageState {
    object Loading : PageState()
    object Success : PageState()
    data class Error(val message: String) : PageState()
}