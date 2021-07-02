package com.google.shinyay.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class BookController {

    @GetMapping
    fun info() = "Spring Data JPA with Kotlin and H2"
    
}