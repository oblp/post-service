package com.example.demo.repository

import com.example.demo.model.entity.Test
import org.springframework.data.repository.CrudRepository

interface TestRepository : CrudRepository<Test, Int>