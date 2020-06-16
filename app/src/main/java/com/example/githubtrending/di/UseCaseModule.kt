package com.example.githubtrending.di

import com.example.githubtrending.data.repository.GitTrendingRepositoryImpl
import com.example.githubtrending.domain.repository.GitTrendingRepository
import com.example.githubtrending.domain.usecase.GetTrendingListUseCase
import com.example.githubtrending.domain.usecase.GetTrendingListUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
abstract class UseCaseModule {
    @Binds
    abstract fun getTrendingListUseCase(getTrendingListUseCaseImpl: GetTrendingListUseCaseImpl): GetTrendingListUseCase

    @Binds
    abstract fun getTrendingRepository(getTrendingRepository: GitTrendingRepositoryImpl): GitTrendingRepository
}