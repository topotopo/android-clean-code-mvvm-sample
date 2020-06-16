package com.example.githubtrending.domain.repository

import com.example.githubtrending.data.helper.ResultStatus
import com.example.githubtrending.domain.model.GitTrendingModel

interface GitTrendingRepository {

    suspend fun fetchGitTrendingList(refresh: Boolean): List<GitTrendingModel>
}