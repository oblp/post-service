package com.example.demo.model.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Test(
        @Id
        @GeneratedValue
        val id: Int,
        val age: Int,
        val name: String,
)