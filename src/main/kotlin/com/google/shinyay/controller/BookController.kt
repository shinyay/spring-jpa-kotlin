package com.google.shinyay.controller

import com.google.shinyay.entity.Book
import com.google.shinyay.repository.BookRepository
import com.google.shinyay.service.BookService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1")
class BookController(val repository: BookRepository, val service: BookService) {
    
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

    @GetMapping("/books/{id}")
    fun findOneBookById(@PathVariable("id") id: Long): ResponseEntity<Optional<Book>> {
        val book = repository.findById(id)
        if (book.isEmpty) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
        return ResponseEntity(book, HttpStatus.OK)
    }

    @PostMapping("/books")
    fun addNewBook(@RequestBody book: Book): ResponseEntity<Book> {
        return ResponseEntity(repository.save(book), HttpStatus.OK)
    }

    @PutMapping("/books")
    fun updateBook(@RequestBody book: Book) {

    }
}