package com.daanidev.ddmini.ui.ingredient.model

data class IngredientResponse(
    val message:String,
    val statusCode:Int,
    val data: List<IngredientList>
)

data class IngredientList(
    val thumbnail:String,
    val ingredientTitle:String,
    val count:Int
)