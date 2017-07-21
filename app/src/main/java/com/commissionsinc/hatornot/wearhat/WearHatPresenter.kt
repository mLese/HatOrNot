package com.commissionsinc.hatornot.wearhat

import com.commissionsinc.hatornot.data.Weather
import com.commissionsinc.hatornot.data.source.WeatherRepository
import com.commissionsinc.hatornot.util.schedulers.BaseSchedulerProvider
import io.reactivex.disposables.CompositeDisposable


class WearHatPresenter constructor (weatherRepository: WeatherRepository, weatherView: WearHatContract.View, schedulerProvider : BaseSchedulerProvider) : WearHatContract.Presenter {

    val mDisposables = CompositeDisposable()
    val mWeatherReposity = weatherRepository
    val mSchedulerProvider = schedulerProvider
    val mWeatherView = weatherView

    init {
        weatherView.setPresenter(this)
    }

    override fun subscribe() {
        loadWeather()
    }

    override fun unsubscribe() {
        mDisposables.dispose()
    }

    override fun loadWeather() {
        mDisposables.clear()
        val disposable =  mWeatherReposity.getWeather()
                .subscribeOn(mSchedulerProvider.computation())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(this::processWeather)
        mDisposables.add(disposable)
    }

    fun processWeather(weather: Weather) {
        mWeatherView.setShouldWearHatCheckStatus(false)
        mWeatherView.setShouldWearHatResultStatus(true)
    }
}