/*
 * Copyright (c) 2020 by Maxine Micu.
 * All rights reserved.
 */

package com.example.githubtrending.data.api

import android.content.Context
import com.example.githubtrending.R
import com.example.githubtrending.data.helper.RawFileReader
import com.example.githubtrending.domain.model.GitTrendingModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import retrofit2.http.GET
import retrofit2.mock.BehaviorDelegate
import java.lang.reflect.Type

/**
 * TODO: This is currently not being used. Placed for demo purpose.
 * Provides mock data for API in scenarios where network is not used.
 * Ex: UI tests / mock environment.
 */
class FakeGitTrendingApi(
    private val delegate: BehaviorDelegate<GitTrendingApi>,
    private val context: Context
) : GitTrendingApi {

    @GET("repositories")
    override suspend fun fetchTrendingRepos(): List<GitTrendingModel> {

        val jsonString = RawFileReader()
            .readRawFile(context, R.raw.mock_git_trending_response)

        val moshi = Moshi.Builder().build()
        val type: Type = Types.newParameterizedType(
            MutableList::class.java,
            GitTrendingModel::class.java
        )
        val adapter = moshi.adapter<List<GitTrendingModel>>(type)
        val gitTrendingList: List<GitTrendingModel> =
            adapter.fromJson(jsonString) ?: mutableListOf()
        return delegate.returningResponse(gitTrendingList).fetchTrendingRepos()
    }


}