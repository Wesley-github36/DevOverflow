package com.wesleymentoor.devoverflow.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.wesleymentoor.devoverflow.common.dispatcher.DispatcherProvider
import com.wesleymentoor.devoverflow.common.dispatcher.DispatcherProviderImpl
import com.wesleymentoor.devoverflow.data.remote.service.DevOverflowApi
import com.wesleymentoor.devoverflow.data.repository.DevOverflowRepositoryImpl
import com.wesleymentoor.devoverflow.domain.repository.DevOverflowRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
//import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRepository(devOverflowApi: DevOverflowApi): DevOverflowRepository {
        return DevOverflowRepositoryImpl(devOverflowApi)
    }

    @Singleton
    @Provides
    fun provideMoshi(): Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

//    @Singleton
//    @Provides
//    fun provideHttpClient(): OkHttpClient = OkHttpClient.Builder()
//        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
//        .build()

    @Singleton
    @Provides
    fun provideRetrofit(moshi: Moshi): Retrofit = Retrofit.Builder()
        .baseUrl("https://api.stackexchange.com/")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    @Singleton
    @Provides
    fun provideDevOverflowApi(retrofit: Retrofit): DevOverflowApi = retrofit.create(DevOverflowApi::class.java)
}