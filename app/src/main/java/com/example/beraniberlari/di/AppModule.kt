package com.example.beraniberlari.di

import com.example.beraniberlari.data.AppCustomDao
import com.example.beraniberlari.data.RunDao
import com.example.beraniberlari.data.TokenDao
import com.example.beraniberlari.data.api.ChuckApi
import com.example.beraniberlari.data.repository.DefaultMainRepository
import com.example.beraniberlari.data.repository.MainRepository
import com.example.beraniberlari.utils.DispathcerProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideMainRepository(
        api : ChuckApi,
        tokenDao: TokenDao,
        appCustomDao: AppCustomDao,
        runDao : RunDao
    ): MainRepository = DefaultMainRepository(api,tokenDao, appCustomDao,runDao)


    @Singleton
    @Provides
    fun provideDispatchers() : DispathcerProvider = object : DispathcerProvider {
        override val main: CoroutineDispatcher
            get() = Dispatchers.Main
        override val io: CoroutineDispatcher
            get() = Dispatchers.IO
        override val default: CoroutineDispatcher
            get() = Dispatchers.Default
        override val unconfined: CoroutineDispatcher
            get() = Dispatchers.Unconfined
    }
}