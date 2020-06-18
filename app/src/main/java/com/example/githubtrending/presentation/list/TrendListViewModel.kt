package com.example.githubtrending.presentation.list

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubtrending.data.helper.ResultStatus
import com.example.githubtrending.domain.usecase.GetTrendingListUseCase
import com.example.githubtrending.presentation.util.PageStateHelper
import com.mmicu.commonadapter.CommonItemHolder
import kotlinx.coroutines.launch

class TrendListViewModel @ViewModelInject constructor(
    private val useCase: GetTrendingListUseCase,
    private val pageStateHelper: PageStateHelper
) :
    ViewModel() {

    val trendingRepoList = MutableLiveData<List<CommonItemHolder<*>>>()
    var pageState = pageStateHelper.pageState

    fun fetchTRendingList(refresh: Boolean) {

        viewModelScope.launch {
            pageStateHelper.setLoadingState()
            when (val response = useCase.getTrendingList(refresh)) {
                is ResultStatus.Success -> {
                    trendingRepoList.postValue(response.data?.map {
                        TrendingItemHolder(
                            data = it
                        )
                    })
                    pageStateHelper.setSuccessState()
                }
                is ResultStatus.Error -> {
                    pageStateHelper.setErrorState(response.exception?.message.toString())
                }
            }
        }
    }
}