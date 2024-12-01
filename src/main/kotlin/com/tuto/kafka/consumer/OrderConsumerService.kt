package com.tuto.kafka.consumer

import com.tuto.kafka.common.Order
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class OrderConsumerService {

    @KafkaListener(topics = ["orders-topic"], groupId = "orders-group")
    fun consumeMessages(order: Order) {
        println("Received order: ${order.orderId}")
    }
}
