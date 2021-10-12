package com.daanidev.ddmini.network

import com.daanidev.ddmini.ui.ingredient.model.IngredientResponse
import io.reactivex.Observable
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {

    override fun getIngredients(): Observable<IngredientResponse> = apiService.getIngredients()

}