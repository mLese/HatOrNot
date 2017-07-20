package com.commissionsinc.hatornot.data.source.remote

import com.commissionsinc.hatornot.data.Weather
import com.commissionsinc.hatornot.data.source.WeatherDataSource
import io.reactivex.Observable
import java.util.concurrent.TimeUnit


object WeatherRemoteDataSource : WeatherDataSource {

    val SERVICE_LATENCY_MS: Long = 5000

    override fun getWeather(): Observable<Weather> {
        return Observable
                .just(Weather(92, false))
                .delay(SERVICE_LATENCY_MS, TimeUnit.MILLISECONDS)
    }

}