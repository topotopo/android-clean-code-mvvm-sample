package com.example.githubtrending.data.helper

/**
 * Represents the different states of Result from API calls.
 */
sealed class ResultStatus<out T : Any?> {
    data class Success<out T : Any?>(val data: T?) : ResultStatus<T>()
    data class Error(val exception: Exception?) : ResultStatus<Nothing>()
}
