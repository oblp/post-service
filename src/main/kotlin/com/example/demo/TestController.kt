package com.example.demo

import com.example.demo.model.entity.Test
import com.example.demo.repository.TestRepository
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/test")
class TestController
constructor(val testRepository: TestRepository) {

    @GetMapping
    @RequestMapping("/{id}")
    fun test(@PathVariable(name = "id") id: Int): Optional<Test> {
        return testRepository.findById(id)
    }

    @PostMapping
    fun test(@RequestBody test: Test): Test {
        return testRepository.save(test)
    }
}