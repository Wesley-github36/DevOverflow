package com.wesleymentoor.devoverflow.di

import com.wesleymentoor.devoverflow.common.dispatcher.DispatcherProvider
import com.wesleymentoor.devoverflow.common.dispatcher.DispatcherProviderImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DispatcherModule {

    @Singleton
    @Provides
    fun provideDispatcherProvider(dispatcherProvider: DispatcherProviderImpl): DispatcherProvider = dispatcherProvider
}