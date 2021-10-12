package com.daanidev.ddmini.ui.neworder.model

data class NewOrderResponse(
    val `data`: List<Data>,
    val status: Status
)

data class Data(
    val addon: List<Addon>,
    val alerted_at: String,
    val created_at: String,
    val expired_at: String,
    val id: Int,
    val quantity: Int,
    val title: String
)

data class Status(
    val message: String,
    val statusCode: Int,
    val success: Boolean
)

data class Addon(
    val id: Int,
    val protein: Int,
    val quantity: Int,
    val title: String
)