package com.example.githubtrending.domain.usecase

import com.example.githubtrending.data.helper.ResultStatus
import com.example.githubtrending.domain.model.GitTrendingModel
import com.example.githubtrending.domain.repository.GitTrendingRepository
import java.io.IOException
import javax.inject.Inject

class UpdateTrendingDetailUseCaseImpl @Inject constructor(val repository: GitTrendingRepository) :
    UpdateTrendingDetailUseCase {

    override suspend fun updateTrendingDetailsUseCase(
        url: String,
        gitTrendingModel: GitTrendingModel
    ): ResultStatus<GitTrendingModel> {
        val response = repository.updateTrendingDetails(url, gitTrendingModel)
        return response?.let {
            ResultStatus.Success(it)
        } ?: ResultStatus.Error(IOException())
    }

}