package com.example.githubtrending.presentation.common

import androidx.lifecycle.MutableLiveData

class PageStateHelper {

    var pageState = MutableLiveData<PageState>()

    fun setErrorState(message: String) {
        pageState.postValue(PageState.Error(message))
    }

    fun setLoadingState() {
        pageState.postValue(PageState.Loading)
    }

    fun setSuccessState() {
        pageState.postValue(PageState.Success)
    }
}