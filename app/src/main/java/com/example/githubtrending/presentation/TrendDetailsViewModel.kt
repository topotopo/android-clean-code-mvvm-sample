package com.example.githubtrending.presentation

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubtrending.data.helper.ResultStatus
import com.example.githubtrending.domain.model.GitTrendingModel
import com.example.githubtrending.domain.usecase.GetTrendingDetailsUseCase
import com.example.githubtrending.presentation.common.PageStateHelper
import kotlinx.coroutines.launch

class TrendDetailsViewModel @ViewModelInject constructor(
    private val useCase: GetTrendingDetailsUseCase,
    private val pageStateHelper: PageStateHelper
) :
    ViewModel() {

    val trendingModel = MutableLiveData<GitTrendingModel>()
    var pageState = pageStateHelper.pageState

    fun getTrendingDetails(url: String) {
        viewModelScope.launch {
            pageStateHelper.setLoadingState()
            when (val result = useCase.getTrendingDetails(url)) {
                is ResultStatus.Success -> {
                    pageStateHelper.setSuccessState()
                    trendingModel.postValue(result.data)
                }
                is ResultStatus.Error -> {
                    pageStateHelper.setErrorState(result.exception?.message.toString())
                }

            }
        }
    }
}