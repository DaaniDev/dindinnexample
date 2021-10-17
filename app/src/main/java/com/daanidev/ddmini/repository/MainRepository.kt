package com.daanidev.ddmini.repository

import com.daanidev.ddmini.ui.ingredient.model.IngredientList
import com.daanidev.ddmini.ui.ingredient.model.IngredientResponse
import com.daanidev.ddmini.ui.neworder.model.NewOrderResponse
import io.reactivex.Observable

interface MainRepository {

    fun getIngredients() : Observable<IngredientResponse>
    fun getNewOrder() : Observable<NewOrderResponse>
}

