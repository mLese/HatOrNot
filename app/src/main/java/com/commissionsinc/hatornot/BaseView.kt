package com.commissionsinc.hatornot

interface BaseView<T> {
    fun setPresenter(presenter: T)
}
