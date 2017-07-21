package com.commissionsinc.hatornot.data.source

import com.commissionsinc.hatornot.data.Weather
import io.reactivex.Observable

class WeatherRepository : WeatherDataSource {

    lateinit var remoteDataSource: WeatherDataSource

    fun registerRemoteDataSource(remoteDataSource: WeatherDataSource) {
        this.remoteDataSource = remoteDataSource
    }

    override fun getWeather(): Observable<Weather> {
        return remoteDataSource.getWeather()
    }

    companion object {
        fun getInstance(remoteDataSource: WeatherDataSource): WeatherRepository {
            val weatherDataSource = WeatherRepository()
            weatherDataSource.remoteDataSource = remoteDataSource
            return weatherDataSource
        }
    }
}
