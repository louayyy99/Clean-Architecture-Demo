package com.blc.data.sample.module

import com.blc.data.sample.remote.SampleApi
import com.blc.data.sample.repository.SampleRepositoryImpl
import com.blc.data.network.NetworkModule
import com.blc.domain.sample.repository.SampleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
class SampleModule {

    @Singleton
    @Provides
    fun provideSampleApi(retrofit: Retrofit): SampleApi {
        return retrofit.create(SampleApi::class.java)
    }

    @Singleton
    @Provides
    fun provideSampleRepository(api: SampleApi): SampleRepository {
        return SampleRepositoryImpl(api)
    }
}

