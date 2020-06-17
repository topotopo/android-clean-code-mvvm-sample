package com.example.githubtrending.domain.usecase

import com.example.githubtrending.data.helper.ResultStatus
import com.example.githubtrending.domain.model.GitTrendingModel
import com.example.githubtrending.domain.repository.GitTrendingRepository
import java.io.IOException
import javax.inject.Inject

class GetTrendingDetailsUseCaseImpl @Inject constructor(private val repository: GitTrendingRepository) :
    GetTrendingDetailsUseCase {

    override suspend fun getTrendingDetails(url: String): ResultStatus<GitTrendingModel> {
        return repository.getGitTrendingDetails(url)?.let {
            ResultStatus.Success(it)
        } ?: ResultStatus.Error(IOException())
    }
}