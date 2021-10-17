package com.daanidev.ddmini.ui.neworder.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.daanidev.ddmini.R
import com.daanidev.ddmini.databinding.FragmentCollectionBinding
import com.daanidev.ddmini.ui.BaseFragment

class CollectionFragment : BaseFragment<FragmentCollectionBinding>() {
    override fun setLayout(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCollectionBinding {

        return DataBindingUtil.inflate(inflater, R.layout.fragment_collection,container,false)
    }

    override fun performBindings() {

    }


}