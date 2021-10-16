package com.daanidev.ddmini.ui.neworder.viewmodel

import android.os.CountDownTimer
import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.daanidev.ddmini.ui.ingredient.model.IngredientResponse
import com.daanidev.ddmini.ui.neworder.model.NewOrderResponse
import com.daanidev.ddmini.usecase.MainUseCase
import com.daanidev.ddmini.utils.AppUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Observable
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class NewOrderViewModel @Inject constructor(private val mainUseCase: MainUseCase): ViewModel() {



     val _timerText = MutableStateFlow("")
    val timerText: StateFlow<String> = _timerText
    fun getNewOrder(): Observable<NewOrderResponse> {
            _timerText.value="abc"
        return mainUseCase.getNewOrder()

    }


}