package com.aleisder.ecommerceapp.di

import com.aleisder.ecommerceapp.Constants
import com.aleisder.ecommerceapp.data.remote.EcommerceApi
import com.aleisder.ecommerceapp.repository.EcommerceRepository
import com.aleisder.ecommerceapp.data.remote.EcommerceRepositoryImpl
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideEcommerceApi(): EcommerceApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(EcommerceApi::class.java)
    }

    @Provides
    @Singleton
    fun provideEcommerceRepository(api: EcommerceApi): EcommerceRepository {
        return EcommerceRepositoryImpl(api)
    }

}