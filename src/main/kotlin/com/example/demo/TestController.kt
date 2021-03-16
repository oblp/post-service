package com.example.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import java.time.Duration

@RestController
@RequestMapping("/test")
class TestController {

    @GetMapping
    fun test(): Flux<Long> {
        return Flux.interval(Duration.ofMillis(200)).take(10)
    }

}