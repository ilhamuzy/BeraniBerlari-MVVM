package com.example.beraniberlari.di

import android.content.Context
import com.example.beraniberlari.data.AppCustomDao
import com.example.beraniberlari.data.AppDatabase
import com.example.beraniberlari.data.RunDao
import com.example.beraniberlari.data.TokenDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

    @Provides
    fun provideTokenDao(appDatabase: AppDatabase): TokenDao {
        return appDatabase.tokenDao()
    }

    @Provides
    fun provideAppCustomDao(appDatabase: AppDatabase): AppCustomDao {
        return appDatabase.appCustomDao()
    }

    @Provides
    fun provideTemplateDao(appDatabase: AppDatabase): RunDao {
        return appDatabase.runDao()
    }
}