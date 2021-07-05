package com.google.shinyay.controller

import com.google.shinyay.entity.Book
import com.google.shinyay.repository.BookRepository
import com.google.shinyay.service.BookService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Book", description = "Book API")
class BookController(val repository: BookRepository, val service: BookService) {
    
    @GetMapping
    fun info() = "Spring Data JPA with Kotlin and H2"

    @GetMapping("/books")
    @Operation(summary = "Find All Books", description = "Display all books which registered")
    @ApiResponses( value = [
        ApiResponse(responseCode = "200", description = "Found Books", content = [
            Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = (ArraySchema(schema = Schema(implementation = Book::class))))
        ]),
        ApiResponse(responseCode = "204", description = "No Content", content = [Content(mediaType = MediaType.APPLICATION_JSON_VALUE)])
    ])
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

    @GetMapping("/books/isbn/{isbn}")
    fun findOneBookByIsbn(@PathVariable("isbn") isbn: Long): ResponseEntity<Optional<Book>> {
        val book = repository.findBookByIsbn(isbn)
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
    fun updateBook(@RequestBody book: Book): ResponseEntity<Book> {
        return ResponseEntity(service.updateBookInformation(book), HttpStatus.OK)
    }

    @DeleteMapping("/books")
    fun deleteAllBooks(): ResponseEntity<Void> {
        val books = repository.findAll()
        if (books.isEmpty()) {
            return ResponseEntity(HttpStatus.NO_CONTENT)
        }
        repository.deleteAll()
        return ResponseEntity(HttpStatus.OK)
    }

    @DeleteMapping("/books/isbn/{isbn}")
    fun deleteOneBookByIsbn(@PathVariable("isbn") isbn: Long): ResponseEntity<Void> {
        val book = repository.findBookByIsbn(isbn)
        if (book.isEmpty) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
        repository.delete(book.get())
        return ResponseEntity(HttpStatus.OK)
    }
}