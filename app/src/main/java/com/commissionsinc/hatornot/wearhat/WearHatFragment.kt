package com.commissionsinc.hatornot.wearhat

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import com.commissionsinc.hatornot.R

class WearHatFragment: Fragment(), WearHatContract.View {

    lateinit var mPresenter: WearHatContract.Presenter

    // Views
    lateinit var mShouldWearHatButton: Button
    lateinit var mShouldWearHatText: TextView
    lateinit var mLoadingProgresBar: ProgressBar

    // Lifecycle
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_wear_hat, container, false)
        mShouldWearHatButton = view.findViewById(R.id.should_wear_hat_button)
        mShouldWearHatText = view.findViewById(R.id.should_wear_hat_text)
        mLoadingProgresBar = view.findViewById(R.id.loading_progress_bar)

        mShouldWearHatButton.setOnClickListener({ _ -> mPresenter.subscribe() })

        return view
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
        mPresenter.unsubscribe()
    }

    // Factory
    companion object {
        fun newInstance(): WearHatFragment {
            val fragment = WearHatFragment()
            return fragment
        }
    }

    // WearHatContract.View
    override fun setPresenter(presenter: WearHatContract.Presenter) {
        mPresenter = presenter
    }

    override fun setLoading(enabled: Boolean) {
        if (enabled) {
            mShouldWearHatButton.isEnabled = false
            mLoadingProgresBar.visibility = View.VISIBLE
        } else {
            mShouldWearHatButton.isEnabled = true
            mLoadingProgresBar.visibility = View.GONE
        }
    }

    override fun setShouldWearHatResultStatus(enabled: Boolean) {
        if (enabled) {
            mShouldWearHatText.setText(R.string.you_should_wear_a_hat)
        } else {
            mShouldWearHatText.setText(R.string.you_should_not_wear_a_hat)
        }
        mShouldWearHatText.visibility = View.VISIBLE
    }
}
