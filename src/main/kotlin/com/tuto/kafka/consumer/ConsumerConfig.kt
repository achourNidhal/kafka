package com.tuto.kafka.consumer

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.support.serializer.JsonDeserializer

@EnableKafka
@Configuration
class ConsumerConfig {

    @Bean
    fun <V> consumerFactory(): ConsumerFactory<String, V> {
        val configProps = mapOf(
            ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG to "localhost:9092",
            ConsumerConfig.GROUP_ID_CONFIG to "example-group",
            ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG to StringDeserializer::class.java,
            ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG to JsonDeserializer::class.java,
            ConsumerConfig.AUTO_OFFSET_RESET_CONFIG to "earliest",
            JsonDeserializer.TRUSTED_PACKAGES to "com.tuto.kafka.*"
        )
        return DefaultKafkaConsumerFactory(configProps)
    }

    @Bean
    fun <V> kafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, V> =
        ConcurrentKafkaListenerContainerFactory<String, V>()
            .apply { consumerFactory = consumerFactory() }
}
