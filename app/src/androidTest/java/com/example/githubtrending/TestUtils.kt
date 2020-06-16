package com.example.githubtrending

import com.example.githubtrending.domain.model.GitTrendingModel


/**
 * Helper methods for instrumentation testing
 */
object TestUtils {

    /**
     * Returns a list of repositoryModels
     */
    fun createRepoModelList(): List<GitTrendingModel> {
        return listOf(
            createRepoModel("1"),
            createRepoModel("2"),
            createRepoModel("3")
        )
    }

    private fun createRepoModel(url: String): GitTrendingModel {
        return GitTrendingModel(
            url, "",
            "", "", "",
            "", "",
            "", "",
            ""
        )
    }
}