/*
 * Copyright (c) 2020 by Maxine Micu.
 * All rights reserved.
 */

package com.example.githubtrending.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.githubtrending.data.local.dao.GitTrendingDao
import com.example.githubtrending.domain.model.GitTrendingModel

@Database(entities = [GitTrendingModel::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getTrendingDao(): GitTrendingDao
}