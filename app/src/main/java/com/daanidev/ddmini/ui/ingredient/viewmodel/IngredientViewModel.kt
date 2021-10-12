package com.daanidev.ddmini.ui.ingredient.viewmodel

import androidx.lifecycle.ViewModel
import com.daanidev.ddmini.repository.MainRepositoryImpl
import com.daanidev.ddmini.ui.ingredient.model.IngredientResponse
import com.daanidev.ddmini.usecase.MainUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Observable
import javax.inject.Inject

@HiltViewModel
class IngredientViewModel @Inject constructor(
    private val mainUseCase: MainUseCase
) : ViewModel() {


    fun getIngredients(): Observable<IngredientResponse> {

        return mainUseCase.getIngredientsUseCase()

    }

}