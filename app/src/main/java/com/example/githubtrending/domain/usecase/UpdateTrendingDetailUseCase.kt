package com.example.githubtrending.domain.usecase

import com.example.githubtrending.data.helper.ResultStatus
import com.example.githubtrending.domain.model.GitTrendingModel

interface UpdateTrendingDetailUseCase {
    suspend fun updateTrendingDetailsUseCase(
        url: String,
        gitTrendingModel: GitTrendingModel
    ): ResultStatus<GitTrendingModel>
}