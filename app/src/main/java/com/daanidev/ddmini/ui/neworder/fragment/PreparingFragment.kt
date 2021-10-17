package com.daanidev.ddmini.ui.neworder.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.daanidev.ddmini.R
import com.daanidev.ddmini.databinding.FragmentPreparingBinding
import com.daanidev.ddmini.ui.BaseFragment

class PreparingFragment : BaseFragment<FragmentPreparingBinding>() {
    override fun setLayout(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentPreparingBinding {

        return DataBindingUtil.inflate(inflater, R.layout.fragment_preparing,container,false)
    }

    override fun performBindings() {

    }
}