package com.daanidev.ddmini.usecase

import com.daanidev.ddmini.repository.MainRepository
import com.daanidev.ddmini.repository.MainRepositoryImpl
import javax.inject.Inject

class MainUseCase  @Inject constructor(private val mainRepository: MainRepository) {

    fun getIngredientsUseCase()=mainRepository.getIngredients()
    fun getNewOrder()=mainRepository.getNewOrder()

}