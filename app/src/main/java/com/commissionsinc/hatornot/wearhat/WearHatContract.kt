package com.commissionsinc.hatornot.wearhat

import com.commissionsinc.hatornot.BasePresenter
import com.commissionsinc.hatornot.BaseView


interface WearHatContract {

    interface View : BaseView<Presenter> {
        fun setShouldWearHatCheckStatus(enabled: Boolean)
        fun setShouldWearHatResultStatus(enabled: Boolean)
    }

    interface Presenter : BasePresenter {
        fun loadWeather()
    }
}