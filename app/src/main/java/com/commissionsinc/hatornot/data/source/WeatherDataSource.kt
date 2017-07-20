package com.commissionsinc.hatornot.data.source

import com.commissionsinc.hatornot.data.Weather
import io.reactivex.Observable

interface WeatherDataSource {
    fun getWeather(): Observable<Weather>
}
