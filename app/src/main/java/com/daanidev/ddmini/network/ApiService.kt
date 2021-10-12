package com.daanidev.ddmini.network

import com.daanidev.ddmini.ui.ingredient.model.IngredientResponse
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("22a94c14-6870-4ddd-be3d-d84f8ba2e6f2")
     fun getIngredients() : Observable<IngredientResponse>
}