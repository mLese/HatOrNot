package com.commissionsinc.hatornot.data.source

import com.commissionsinc.hatornot.data.Weather
import io.reactivex.Observable

object WeatherRepository : WeatherDataSource {

    lateinit var remoteDataSource: WeatherDataSource
    lateinit var localDataSource: WeatherDataSource

    fun registerRemoteDataSource(remoteDataSource: WeatherDataSource) {
        this.remoteDataSource = checkNotNull(remoteDataSource)
    }

    fun registerLocalDataSource(localDataSource: WeatherDataSource) {
        this.localDataSource = checkNotNull(localDataSource)
    }
    
    override fun getWeather(): Observable<Weather> {
        return remoteDataSource.getWeather()
    }

}
