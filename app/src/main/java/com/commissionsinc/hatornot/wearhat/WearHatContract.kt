package com.commissionsinc.hatornot.wearhat

import com.commissionsinc.hatornot.BasePresenter
import com.commissionsinc.hatornot.BaseView


interface WearHatContract {

    interface View : BaseView<Presenter> {
        fun setLoadingIndicator(active: Boolean)
        fun setHatStatus(enabled: Boolean)
    }

    interface Presenter : BasePresenter {
        fun loadWeather(zip: Int)
    }
}