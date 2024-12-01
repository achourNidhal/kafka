package com.tuto.kafka

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class KafkaApplication : CommandLineRunner {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(KafkaApplication::class.java, *args)
        }
    }

    override fun run(vararg args: String?) {

    }
}
