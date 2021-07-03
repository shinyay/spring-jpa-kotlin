package com.google.shinyay.controller

import com.google.shinyay.entity.Book
import com.google.shinyay.repository.BookRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class BookController(val repository: BookRepository) {
    
    @GetMapping
    fun info() = "Spring Data JPA with Kotlin and H2"

    @GetMapping("/books")
    fun findAllBooks(): ResponseEntity<MutableList<Book>> {
        val books = repository.findAll()
        if (books.isEmpty()) {
            return ResponseEntity(HttpStatus.NO_CONTENT)
        }
        return ResponseEntity(books, HttpStatus.OK)
    }
}