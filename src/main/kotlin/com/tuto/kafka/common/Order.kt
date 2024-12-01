package com.tuto.kafka.common

data class Order(
    val orderId: String,
    val customerId: String,
    val product: String,
    val amount: Double
)
