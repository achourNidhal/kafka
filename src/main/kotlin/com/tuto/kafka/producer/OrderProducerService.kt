package com.tuto.kafka.producer

import com.tuto.kafka.common.Order
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class OrderProducerService(private val kafaTemplate: KafkaTemplate<String, Order>) {

    fun sendOrder(order: Order) {
        val orderJson =
            """{"orderId": "${order.orderId}", "customerId": "${order.customerId}", "product": "${order.product}", "amount": ${order.amount}}"""
        kafaTemplate.send("orders-topic", order.orderId, order)
        println("Order sent: $orderJson")

    }
}
