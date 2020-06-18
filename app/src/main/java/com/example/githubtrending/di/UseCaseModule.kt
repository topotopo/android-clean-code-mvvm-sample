package com.example.githubtrending.di

import com.example.githubtrending.data.repository.GitTrendingRepositoryImpl
import com.example.githubtrending.domain.repository.GitTrendingRepository
import com.example.githubtrending.domain.usecase.*
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
    abstract fun getTrendingDetailsUseCase(getTrendingDetailsUseCase: GetTrendingDetailsUseCaseImpl): GetTrendingDetailsUseCase

    @Binds
    abstract fun updateTrendingDetailsUseCase(updateTrendingDetailUseCase: UpdateTrendingDetailUseCaseImpl) : UpdateTrendingDetailUseCase

    @Binds
    abstract fun getTrendingRepository(getTrendingRepository: GitTrendingRepositoryImpl): GitTrendingRepository
}