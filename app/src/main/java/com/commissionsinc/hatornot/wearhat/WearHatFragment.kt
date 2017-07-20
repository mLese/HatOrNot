package com.commissionsinc.hatornot.wearhat

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.commissionsinc.hatornot.R

class WearHatFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_wear_hat, container, false)
    }

    companion object {
        fun newInstance(): WearHatFragment {
            val fragment = WearHatFragment()
            return fragment
        }
    }
}
