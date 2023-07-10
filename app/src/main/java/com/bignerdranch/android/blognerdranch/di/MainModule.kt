package com.bignerdranch.android.blognerdranch.di

import com.bignerdranch.android.blognerdranch.data.BlogService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object MainModule {

    @Provides
    fun blogService(): BlogService {
        return Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8106/") // "localhost" is the emulator's host. 10.0.2.2 goes to your computer
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }
}