package com.daanidev.ddmini.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<Binding: ViewDataBinding>: Fragment() {

    private var _binding: Binding? = null
    protected val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = setLayout(inflater, container)
        return binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        performBindings()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        cleanup()
        _binding = null
    }


    protected abstract fun setLayout(inflater: LayoutInflater, container: ViewGroup?): Binding

    protected abstract fun performBindings()

    protected open fun cleanup() {}
}