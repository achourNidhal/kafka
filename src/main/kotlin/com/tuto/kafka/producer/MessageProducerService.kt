package com.tuto.kafka.producer

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.SendResult
import org.springframework.stereotype.Service
import java.util.concurrent.CompletableFuture

@Service
class MessageProducerService(private val kafkaTemplate: KafkaTemplate<String, String>) {

    fun sendMessage(topic: String, key: String, message: String) {

        val future: CompletableFuture<SendResult<String, String>> = kafkaTemplate.send(topic, key, message)
        future.whenComplete { result, ex ->
            if (ex == null) {
                println("Sent message=[$message] with offset=[${result?.recordMetadata?.offset()}]")
                "Message sent successfully to topic=${result?.recordMetadata?.topic()}, " +
                        "partition=${result?.recordMetadata?.partition()}, offset=${result?.recordMetadata?.offset()}"
            } else {
                println("Unable to send message=[$message] due to : ${ex.message}")
            }
        }
    }
}
