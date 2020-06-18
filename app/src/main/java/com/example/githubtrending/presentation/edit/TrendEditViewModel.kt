package com.example.githubtrending.presentation.edit

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubtrending.data.helper.ResultStatus
import com.example.githubtrending.domain.model.GitTrendingModel
import com.example.githubtrending.domain.usecase.GetTrendingDetailsUseCase
import com.example.githubtrending.domain.usecase.UpdateTrendingDetailUseCase
import com.example.githubtrending.presentation.util.PageStateHelper
import kotlinx.coroutines.launch

class TrendEditViewModel @ViewModelInject constructor(
    private val getTrendingDetailsUseCase: GetTrendingDetailsUseCase,
    private val updateTrendingDetailsUseCase: UpdateTrendingDetailUseCase,
    private val pageStateHelper: PageStateHelper
) : ViewModel() {

    val trendingModel = MutableLiveData<GitTrendingModel>()
    var pageState = pageStateHelper.pageState

    fun getTrendingDetails(url: String) {
        viewModelScope.launch {
            pageStateHelper.setLoadingState()
            when (val result = getTrendingDetailsUseCase.getTrendingDetails(url)) {
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

    fun updateTrendingDetails(url: String, gitTrendingModel: GitTrendingModel) {
        viewModelScope.launch {
            pageStateHelper.setLoadingState()
            when(val result = updateTrendingDetailsUseCase.updateTrendingDetailsUseCase(url, gitTrendingModel)) {
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