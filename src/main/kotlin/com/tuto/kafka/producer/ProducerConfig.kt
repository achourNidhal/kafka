package com.tuto.kafka.producer

import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory
import org.springframework.kafka.support.serializer.JsonDeserializer
import org.springframework.kafka.support.serializer.JsonSerializer

@EnableKafka
@Configuration
class ProducerConfig {

    @Bean
    fun <V> producerFactory(): ProducerFactory<String, V> {
        val configProps = mapOf(
            ProducerConfig.BOOTSTRAP_SERVERS_CONFIG to "localhost:9092",
            ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG to StringSerializer::class.java,
            ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG to JsonSerializer::class.java,
            JsonDeserializer.TRUSTED_PACKAGES to "com.tuto.kafka.*"
        )
        return DefaultKafkaProducerFactory(configProps)

    }

    @Bean
    fun <V> kafkaTemplate(): KafkaTemplate<String, V> {
        return KafkaTemplate(producerFactory())
    }
}

