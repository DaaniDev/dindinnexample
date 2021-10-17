package com.daanidev.ddmini.ui.ingredient.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.daanidev.ddmini.R
import com.daanidev.ddmini.databinding.FragmentBentoBinding
import com.daanidev.ddmini.ui.BaseFragment
import com.daanidev.ddmini.ui.ingredient.EditTextValueListener
import com.daanidev.ddmini.ui.ingredient.IngredientTabActivity
import com.daanidev.ddmini.ui.ingredient.adapter.IngredientListAdapter
import com.daanidev.ddmini.ui.ingredient.model.IngredientResponse
import com.daanidev.ddmini.ui.ingredient.viewmodel.IngredientViewModel
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

@AndroidEntryPoint
class BentoFragment : BaseFragment<FragmentBentoBinding>(),EditTextValueListener {

    private val viewModel by viewModels<IngredientViewModel>()
    private lateinit var listAdapter: IngredientListAdapter
    override fun setLayout(inflater: LayoutInflater, container: ViewGroup?): FragmentBentoBinding {

        return DataBindingUtil.inflate(inflater, R.layout.fragment_bento, container, false)
    }

    override fun performBindings() {

        // Ingredient List Adapter with kotlin high order function
        listAdapter = IngredientListAdapter {

        }


        binding.listIngredients.apply {
            this.layoutManager = StaggeredGridLayoutManager(5, RecyclerView.VERTICAL)
            this.adapter = listAdapter
        }

        //this can be replace by coroutines flow which is more concise than this
        viewModel.getIngredients().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<IngredientResponse> {
                override fun onSubscribe(d: Disposable) {
                    //
                }

                override fun onNext(t: IngredientResponse) {

                    listAdapter.setList(t.data)
                }

                override fun onError(e: Throwable) {
                    throw e
                }

                override fun onComplete() {
                    // hide progress
                }


            })

        (activity as IngredientTabActivity).setListener(this)
    }

    override fun onChange(string: String) {

        if(string.isEmpty())
        {
            binding.listIngredients.visibility= View.VISIBLE
            binding.tvNotData.visibility=View.GONE
        }
        else{
            binding.listIngredients.visibility= View.GONE
            binding.tvNotData.visibility=View.VISIBLE
        }
    }
}