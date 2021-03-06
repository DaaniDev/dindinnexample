package com.daanidev.ddmini.network

import com.daanidev.ddmini.ui.ingredient.model.IngredientList
import com.daanidev.ddmini.ui.ingredient.model.IngredientResponse
import com.daanidev.ddmini.ui.neworder.model.NewOrderResponse
import io.reactivex.Observable
import retrofit2.Response

interface ApiHelper {

      fun getIngredients() : Observable<IngredientResponse>
      fun getNewOrder() : Observable<NewOrderResponse>
}