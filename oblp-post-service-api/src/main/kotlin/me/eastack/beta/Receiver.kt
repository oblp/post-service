package me.eastack.beta

import org.springframework.stereotype.Component
import java.util.concurrent.CountDownLatch

@Component
class Receiver {
    var latch = CountDownLatch(1)

    fun receiveMessage(message: String) {
        println("Received<$message>")
        latch.countDown()
    }
}