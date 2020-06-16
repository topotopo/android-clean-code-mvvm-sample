package com.example.githubtrending.data.repository

import com.example.githubtrending.data.api.GitTrendingApi
import com.example.githubtrending.domain.model.GitTrendingModel
import com.example.githubtrending.domain.repository.GitTrendingRepository

class GitTrendingRepositoryImpl(private val trendingApi: GitTrendingApi) : GitTrendingRepository {

    override suspend fun fetchGitTrendingList(refresh: Boolean): List<GitTrendingModel>? {
        return trendingApi.fetchTrendingRepos()
    }

}