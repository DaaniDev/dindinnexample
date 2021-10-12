package com.daanidev.ddmini.ui.neworder.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daanidev.ddmini.R
import com.daanidev.ddmini.databinding.FragmentIncomingBinding
import com.daanidev.ddmini.ui.BaseFragment
import com.daanidev.ddmini.ui.neworder.adapter.IncomingOrderAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class IncomingFragment : BaseFragment<FragmentIncomingBinding>() {

    private lateinit var incomingOrderAdapter: IncomingOrderAdapter
    override fun setLayout(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentIncomingBinding {

        return DataBindingUtil.inflate(inflater, R.layout.fragment_incoming,container,false)
    }

    override fun performBindings() {

        incomingOrderAdapter = IncomingOrderAdapter(requireContext())


        binding.listIncoming.apply {
            this.layoutManager=LinearLayoutManager(requireContext(),RecyclerView.HORIZONTAL,false)
            this.adapter=incomingOrderAdapter
        }
    }


}