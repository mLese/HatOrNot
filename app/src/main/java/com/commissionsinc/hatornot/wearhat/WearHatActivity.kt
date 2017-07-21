package com.commissionsinc.hatornot.wearhat

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.commissionsinc.hatornot.Injection
import com.commissionsinc.hatornot.R
import com.commissionsinc.hatornot.util.ActivityUtils

class WearHatActivity : AppCompatActivity() {

    lateinit var mWearHatPresenter: WearHatContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wear_hat)

        // Set up content fragment
        var wearHatFragment: WearHatFragment? = supportFragmentManager.findFragmentById(R.id.frame_content) as WearHatFragment?
        if (wearHatFragment == null) {
            wearHatFragment = WearHatFragment.newInstance()
            ActivityUtils.addFragmentToActivity(supportFragmentManager, wearHatFragment, R.id.frame_content)
        }

        // Create Presenter
        mWearHatPresenter = WearHatPresenter(Injection.provideWeatherRepository(applicationContext), wearHatFragment, Injection.provideSchedulerProvider())
        wearHatFragment.setPresenter(mWearHatPresenter)
    }
}
