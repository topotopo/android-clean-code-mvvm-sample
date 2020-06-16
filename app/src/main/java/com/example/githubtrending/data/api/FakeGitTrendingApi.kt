/*
 * Copyright (c) 2020 by Maxine Micu.
 * All rights reserved.
 */

package com.example.githubtrending.data.api

import android.content.Context
import com.example.githubtrending.R
import com.example.githubtrending.data.helper.FakeJsonFileReader
import com.example.githubtrending.domain.model.GitTrendingModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import retrofit2.http.GET
import retrofit2.mock.BehaviorDelegate
import java.lang.reflect.Type

class FakeGitTrendingApi(
    private val delegate: BehaviorDelegate<GitTrendingApi>,
    private val context: Context
) : GitTrendingApi {

    @GET("repositories")
    override suspend fun fetchTrendingRepos(): List<GitTrendingModel> {

        val jsonString = FakeJsonFileReader()
            .readMockJson(context, R.raw.mock_git_trending_response)

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