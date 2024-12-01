package com.tuto.kafka.consumer

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class MessageConsumerService {

    @KafkaListener(topics = ["messages-topic"], groupId = "messages-group")
    fun consumeMessages(message: String) {
        println("Received message: $message")
    }
}
