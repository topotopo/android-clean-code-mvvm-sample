package com.example.githubtrending.presentation.util

import androidx.lifecycle.MutableLiveData

/**
 * Updates the different state of the PageState in a LiveData
 */
class PageStateHelper {

    var pageState = MutableLiveData<PageState>()

    fun setErrorState(message: String) {
        pageState.postValue(
            PageState.Error(
                message
            )
        )
    }

    fun setLoadingState() {
        pageState.postValue(PageState.Loading)
    }

    fun setSuccessState() {
        pageState.postValue(PageState.Success)
    }
}