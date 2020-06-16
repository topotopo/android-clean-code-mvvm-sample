package com.example.githubtrending.presentation

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubtrending.data.helper.ResultStatus
import com.example.githubtrending.domain.usecase.GetTrendingListUseCase
import com.example.githubtrending.presentation.common.PageState
import com.mmicu.commonadapter.CommonItemHolder
import kotlinx.coroutines.launch
import java.lang.Error

class TrendListViewModel @ViewModelInject constructor(private val useCase: GetTrendingListUseCase) :
    ViewModel() {

    val trendingRepoList = MutableLiveData<List<CommonItemHolder<*>>>()
    var pageState = MutableLiveData<PageState>()

    fun fetchTRendingList(refresh: Boolean) {

        viewModelScope.launch {
            setLoadingState()
            when (val response = useCase.getTrendingList(refresh)) {
                is ResultStatus.Success -> {
                    trendingRepoList.postValue(response.data?.map {
                        TrendingItemHolder(data = it)
                    })
                    setSuccessState()
                }
                is Error -> {
                    setErrorState(response.message ?: "")
                }
            }
        }
    }

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