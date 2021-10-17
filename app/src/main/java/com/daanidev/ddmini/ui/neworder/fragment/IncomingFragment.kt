package com.daanidev.ddmini.ui.neworder.fragment

import android.os.CountDownTimer
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daanidev.ddmini.R
import com.daanidev.ddmini.databinding.FragmentIncomingBinding
import com.daanidev.ddmini.ui.BaseFragment
import com.daanidev.ddmini.ui.ingredient.model.IngredientResponse
import com.daanidev.ddmini.ui.neworder.NewOrderActivity
import com.daanidev.ddmini.ui.neworder.adapter.IncomingOrderAdapter
import com.daanidev.ddmini.ui.neworder.model.NewOrderResponse
import com.daanidev.ddmini.ui.neworder.viewmodel.NewOrderViewModel
import com.daanidev.ddmini.utils.AppUtils
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class IncomingFragment : BaseFragment<FragmentIncomingBinding>() {

    private val viewModel by viewModels<NewOrderViewModel>()
    private lateinit var incomingOrderAdapter: IncomingOrderAdapter
    override fun setLayout(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentIncomingBinding {

        return DataBindingUtil.inflate(inflater, R.layout.fragment_incoming, container, false)
    }

    override fun performBindings() {

        incomingOrderAdapter = IncomingOrderAdapter(requireActivity())


        binding.listIncoming.apply {
            this.layoutManager =
                LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
            this.adapter = incomingOrderAdapter
        }

       lifecycleScope.launch {
           getOrders()
           delay(10000L)
           getOrders()

       }

    }

    private fun getOrders(){
        viewModel.getNewOrder().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<NewOrderResponse> {
                override fun onSubscribe(d: Disposable) {
                    //
                }

                override fun onNext(t: NewOrderResponse) {
                    incomingOrderAdapter.addNewOrder(t)
                    (activity as NewOrderActivity).setOrderCount(incomingOrderAdapter.itemCount)

                }

                override fun onError(e: Throwable) {
                    throw e
                }

                override fun onComplete() {
                    // hide progress
                }


            })


    }



}