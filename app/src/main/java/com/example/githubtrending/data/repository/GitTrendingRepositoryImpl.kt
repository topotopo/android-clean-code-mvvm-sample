package com.example.githubtrending.data.repository

import com.example.githubtrending.data.api.GitTrendingApi
import com.example.githubtrending.data.local.dao.GitTrendingDao
import com.example.githubtrending.domain.model.GitTrendingModel
import com.example.githubtrending.domain.repository.GitTrendingRepository
import javax.inject.Inject

class GitTrendingRepositoryImpl @Inject constructor(
    private val trendingApi: GitTrendingApi,
    private val gitTrendingDao: GitTrendingDao
) : GitTrendingRepository {

    override suspend fun fetchGitTrendingList(refresh: Boolean): List<GitTrendingModel> {
        return if (refresh || gitTrendingDao.getAll().isEmpty()) {
            val response = trendingApi.fetchTrendingRepos()
            gitTrendingDao.replaceAll(response)
            response
        } else {
            gitTrendingDao.getAll()
        }
    }

    override suspend fun getGitTrendingDetails(url: String): GitTrendingModel? {
        return gitTrendingDao.get(url)
    }
}