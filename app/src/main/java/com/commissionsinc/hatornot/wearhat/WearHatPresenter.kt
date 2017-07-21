package com.commissionsinc.hatornot.wearhat

import com.commissionsinc.hatornot.data.Weather
import com.commissionsinc.hatornot.data.source.WeatherRepository
import com.commissionsinc.hatornot.util.schedulers.BaseSchedulerProvider
import io.reactivex.disposables.CompositeDisposable


class WearHatPresenter(val mWeatherRepository: WeatherRepository,
                       val mWeatherView: WearHatContract.View,
                       val mSchedulerProvider : BaseSchedulerProvider) : WearHatContract.Presenter {

    val mDisposables = CompositeDisposable()

    init {
        mWeatherView.setPresenter(this)
    }

    override fun subscribe() {
        loadWeather()
    }

    override fun unsubscribe() {
        mDisposables.dispose()
    }

    override fun loadWeather() {
        mDisposables.clear()
        mWeatherView.setLoading(true)
        val disposable =  mWeatherRepository.getWeather()
                .subscribeOn(mSchedulerProvider.computation())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(this::processWeather,
                        { _ -> mWeatherView.setLoading(false) },
                        { mWeatherView.setLoading(false) })
        mDisposables.add(disposable)
    }

    fun processWeather(weather: Weather) {
        if (weather.temp > 90 && !weather.cloudy) {
            mWeatherView.setShouldWearHatResultStatus(true)
        } else {
            mWeatherView.setShouldWearHatResultStatus(false)
        }
    }
}