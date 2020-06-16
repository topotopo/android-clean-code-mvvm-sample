package com.example.githubtrending.di

import androidx.databinding.library.BuildConfig
import com.example.githubtrending.data.api.GitTrendingApi
import com.itkacher.okhttpprofiler.OkHttpProfilerInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(ApplicationComponent::class)
 class NetworkModule {

    @Provides
    fun provideLoginRetrofitService(okHttpClient: OkHttpClient): Retrofit  {
        return Retrofit.Builder().baseUrl("https://github-trending-api.now.sh/")
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create()).build()
    }

    @Provides
    fun provideClient(logging: HttpLoggingInterceptor): OkHttpClient {
        val okHttpClient = OkHttpClient().newBuilder()
        okHttpClient.addInterceptor(logging)
        if(BuildConfig.DEBUG) {
            okHttpClient.addInterceptor(OkHttpProfilerInterceptor())
        }
        return OkHttpClient().newBuilder().build()
    }

    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        } else {
            logging.setLevel(HttpLoggingInterceptor.Level.NONE)
        }
        return logging
    }

    @Provides
    fun provideCartApi(retrofit: Retrofit): GitTrendingApi {
        return retrofit.create(GitTrendingApi::class.java)
    }
}