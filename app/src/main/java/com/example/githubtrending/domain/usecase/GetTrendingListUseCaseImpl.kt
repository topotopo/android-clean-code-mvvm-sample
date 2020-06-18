package com.example.githubtrending.domain.usecase

import com.example.githubtrending.data.helper.NetworkCallHelper.safeApiCall
import com.example.githubtrending.data.helper.ResultStatus
import com.example.githubtrending.data.local.dao.GitTrendingDao
import com.example.githubtrending.domain.model.GitTrendingModel
import com.example.githubtrending.domain.repository.GitTrendingRepository
import javax.inject.Inject

class GetTrendingListUseCaseImpl @Inject constructor(private val gitTrendingRepo: GitTrendingRepository) :
    GetTrendingListUseCase {

    override suspend fun getTrendingList(refresh: Boolean): ResultStatus<List<GitTrendingModel>> {

        val response = safeApiCall {
            gitTrendingRepo.fetchGitTrendingList(refresh)
        }
        return when (response) {
            is ResultStatus.Success -> {
                ResultStatus.Success(response.data)
            }
            is ResultStatus.Error -> {
                ResultStatus.Error(response.exception)
            }
        }
    }
}