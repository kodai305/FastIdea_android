package com.example.fastidea_android

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class MandaraParentFragment : Fragment() {
    // フラグメントの再生成は注意. Chapter7 366

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.mandara_parent_fragment, container, false)
        return view
    }
}

fun newMandaraParentFragment() : MandaraParentFragment {
    val fragment = MandaraParentFragment()

    return fragment
}