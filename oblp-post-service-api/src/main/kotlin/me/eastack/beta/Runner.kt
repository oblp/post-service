package me.eastack.beta

import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.util.concurrent.TimeUnit

@Component
class Runner(val receiver: Receiver, val rabbitTemplate: RabbitTemplate) : CommandLineRunner {
    override fun run(vararg args: String?) {
        println("Sending message...")
        rabbitTemplate.convertAndSend("spring-boot-exchange", "foo.bar.baz", "Hello from RabbitMQ")
        receiver.latch.await(1000, TimeUnit.MILLISECONDS)
    }
}