package com.example.githubtrending.data.api

import com.example.githubtrending.domain.model.GitTrendingModel
import retrofit2.http.GET

interface GitTrendingApi {

    @GET("repositories")
    suspend fun fetchTrendingRepos(): List<GitTrendingModel>

}