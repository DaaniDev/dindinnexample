package com.daanidev.ddmini.ui.ingredient.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.daanidev.ddmini.R
import com.daanidev.ddmini.databinding.FragmentBentoBinding
import com.daanidev.ddmini.ui.BaseFragment

class AppetizerFragment : BaseFragment<FragmentBentoBinding>(){
    override fun setLayout(inflater: LayoutInflater, container: ViewGroup?): FragmentBentoBinding {

        return DataBindingUtil.inflate(inflater, R.layout.fragment_bento,container,false)
    }

    override fun performBindings() {

    }
}