package com.example.nbc_challenge.di

import com.example.nbc_challenge.data.repository.HomeShelfRepositoryImpl
import com.example.nbc_challenge.domain.repository.HomeShelfRepository
import com.example.nbc_challenge.domain.usecase.GetHomeShelvesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @OptIn(ExperimentalSerializationApi::class)
    @Provides @Singleton
    fun provideJson(): Json = Json {
        ignoreUnknownKeys = true
        isLenient = true
        allowTrailingComma = true
        coerceInputValues = true
    }

    @Provides @Singleton
    fun provideHomeShelfRepository(
        homeShelfImpl: HomeShelfRepositoryImpl
    ): HomeShelfRepository = homeShelfImpl


    @Provides
    fun provideGetHomeShelvesUseCase(
        homeShelfRepository: HomeShelfRepository
    ): GetHomeShelvesUseCase = GetHomeShelvesUseCase(
        homeShelfRepository
    )
}