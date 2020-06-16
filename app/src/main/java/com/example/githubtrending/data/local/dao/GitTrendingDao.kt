/*
 * Copyright (c) 2020 by Maxine Micu.
 * All rights reserved.
 */

package com.example.githubtrending.data.local.dao

import androidx.room.*
import com.example.githubtrending.domain.model.GitTrendingModel

@Dao
abstract class GitTrendingDao {

    @Query("SELECT * FROM GitTrendingModel")
    abstract suspend fun getAll(): List<GitTrendingModel>

    @Insert
    abstract suspend fun insertAll(repositoryModels: List<GitTrendingModel>)

    @Delete
    abstract suspend fun delete(repositoryModel: GitTrendingModel)

    @Query("DELETE FROM GitTrendingModel")
    abstract suspend fun deleteAll()

    @Update
    abstract suspend fun update(repositoryModel: GitTrendingModel)

    @Transaction
    open suspend fun replaceAll(repositoryModels: List<GitTrendingModel>) {
        deleteAll()
        insertAll(repositoryModels)
    }
}