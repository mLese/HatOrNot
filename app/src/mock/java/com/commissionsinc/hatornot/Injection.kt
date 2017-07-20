package com.commissionsinc.hatornot

import android.content.Context


class Injection {
    companion object {
        fun provideWeatherRepository(context: Context) {
            checkNotNull(context)
        }
    }
}