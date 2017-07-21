package com.commissionsinc.hatornot

import android.content.Context
import com.commissionsinc.hatornot.data.source.WeatherDataSource
import com.commissionsinc.hatornot.data.source.WeatherRepository
import com.commissionsinc.hatornot.data.source.remote.WeatherRemoteDataSource
import com.commissionsinc.hatornot.util.schedulers.BaseSchedulerProvider
import com.commissionsinc.hatornot.util.schedulers.SchedulerProvider


object Injection {
    fun provideWeatherRepository(context: Context) : WeatherRepository {
        return WeatherRepository.getInstance(WeatherRemoteDataSource)
    }

    fun provideSchedulerProvider(): BaseSchedulerProvider {
        return SchedulerProvider.getInstance()
    }
}