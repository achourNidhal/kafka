package com.tuto.kafka.producer

import com.tuto.kafka.common.Order
import org.springframework.web.bind.annotation.*

@RestController
class ProducerController(
    private val messageProducerService: MessageProducerService,
    private val orderProducerService: OrderProducerService
) {

    @GetMapping("/send-message")
    fun sendMessage(
        @RequestParam topic: String,
        @RequestParam key: String,
        @RequestParam message: String
    ): String {
        messageProducerService.sendMessage(topic, key, message)
        return "Message sent to topic: $topic"
    }

    @PostMapping("/send-order")
    fun createOrder(@RequestBody order: Order): String {
        orderProducerService.sendOrder(order)
        return "Order sent: ${order.orderId}"
    }

}
