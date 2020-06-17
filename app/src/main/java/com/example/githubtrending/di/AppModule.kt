package com.example.githubtrending.di

import android.content.Context
import androidx.room.Room
import com.example.githubtrending.data.local.AppDatabase
import com.example.githubtrending.data.local.dao.GitTrendingDao
import com.example.githubtrending.presentation.util.PageStateHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ApplicationComponent::class)
class AppModule {

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java, "git-trending-db"
        ).build()
    }

    @Provides
    fun provideDao(appDatabase: AppDatabase): GitTrendingDao {
        return appDatabase.getTrendingDao()
    }

    @Provides
    fun providePageStateHelper() : PageStateHelper {
        return PageStateHelper()
    }
}