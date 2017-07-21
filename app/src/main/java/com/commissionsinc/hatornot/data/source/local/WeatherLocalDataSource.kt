package com.commissionsinc.hatornot.data.source.local

import com.commissionsinc.hatornot.data.Weather
import com.commissionsinc.hatornot.data.source.WeatherDataSource
import com.squareup.sqlbrite.BriteDatabase
import io.reactivex.Observable

class WeatherLocalDataSource: WeatherDataSource {

    lateinit var databaseHelper: BriteDatabase

    override fun getWeather(): Observable<Weather> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
