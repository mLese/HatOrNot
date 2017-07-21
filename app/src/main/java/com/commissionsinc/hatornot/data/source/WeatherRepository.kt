package com.commissionsinc.hatornot.data.source

import com.commissionsinc.hatornot.data.Weather
import io.reactivex.Observable

class WeatherRepository : WeatherDataSource {

    lateinit var mRemoteDataSource: WeatherDataSource

    fun registerRemoteDataSource(remoteDataSource: WeatherDataSource) {
        this.mRemoteDataSource = remoteDataSource
    }

    override fun getWeather(): Observable<Weather> {
        return mRemoteDataSource.getWeather()
    }

    companion object {
        fun getInstance(remoteDataSource: WeatherDataSource): WeatherRepository {
            val weatherDataSource = WeatherRepository()
            weatherDataSource.mRemoteDataSource = remoteDataSource
            return weatherDataSource
        }
    }
}
