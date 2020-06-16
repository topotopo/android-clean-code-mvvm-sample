package com.example.githubtrending.domain.usecase

import com.example.githubtrending.data.helper.ResultStatus
import com.example.githubtrending.domain.model.GitTrendingModel

interface GetTrendingListUseCase {

    suspend fun getTrendingList(refresh: Boolean) : ResultStatus<List<GitTrendingModel>>
}