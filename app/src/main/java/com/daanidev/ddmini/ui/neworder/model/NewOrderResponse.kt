package com.daanidev.ddmini.ui.neworder.model

data class NewOrderResponse(
    val alerted_at: String,
    val created_at: String,
    val `data`: List<Data>,
    val expired_at: String,
    val order_id: Int,
    val status: Status,
    val time: String
)

data class Data(
    val addon: List<Addon>,
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