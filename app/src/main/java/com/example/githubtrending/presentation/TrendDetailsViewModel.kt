package com.example.githubtrending.presentation

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubtrending.data.helper.ResultStatus
import com.example.githubtrending.domain.model.GitTrendingModel
import com.example.githubtrending.domain.usecase.GetTrendingDetailsUseCase
import com.example.githubtrending.presentation.common.PageState
import kotlinx.coroutines.launch

class TrendDetailsViewModel @ViewModelInject constructor(private val useCase: GetTrendingDetailsUseCase) :
    ViewModel() {

    val trendingModel = MutableLiveData<GitTrendingModel>()
    var pageState = MutableLiveData<PageState>()

    fun getTrendingDetails(url: String) {
        viewModelScope.launch {
            pageState.postValue(PageState.Loading)
            when (val result = useCase.getTrendingDetails(url)) {
                is ResultStatus.Success -> {
                    pageState.postValue(PageState.Success)
                    trendingModel.postValue(result.data)
                }
                is ResultStatus.Error -> {
                    pageState.postValue(PageState.Error(result.exception?.message.toString()))
                }

            }
        }
    }
}