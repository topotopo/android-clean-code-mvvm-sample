package com.example.githubtrending.domain.usecase

import com.example.githubtrending.data.helper.ResultStatus
import com.example.githubtrending.domain.model.GitTrendingModel

interface GetTrendingDetailsUseCase {
    suspend fun getTrendingDetails(url: String): ResultStatus<GitTrendingModel>
}