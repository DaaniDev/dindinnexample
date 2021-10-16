package com.daanidev.ddmini.repository

import com.daanidev.ddmini.network.ApiHelper
import com.daanidev.ddmini.ui.ingredient.model.IngredientList
import com.daanidev.ddmini.ui.ingredient.model.IngredientResponse
import com.daanidev.ddmini.ui.neworder.model.NewOrderResponse
import io.reactivex.Observable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(private val apiHelper: ApiHelper) : MainRepository{

    override fun getIngredients()= apiHelper.getIngredients()
    override fun getNewOrder() = apiHelper.getNewOrder()
}