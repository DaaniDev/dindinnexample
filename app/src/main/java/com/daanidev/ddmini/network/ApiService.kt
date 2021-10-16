package com.daanidev.ddmini.network

import com.daanidev.ddmini.ui.ingredient.model.IngredientResponse
import com.daanidev.ddmini.ui.neworder.model.NewOrderResponse
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("22a94c14-6870-4ddd-be3d-d84f8ba2e6f2")
     fun getIngredients() : Observable<IngredientResponse>

     @GET("3e95874f-0faa-4fa1-8036-c034c2ef3d45")
     fun getNewOrder() : Observable<NewOrderResponse>
}