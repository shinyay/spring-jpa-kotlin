package com.google.shinyay.service

import com.google.shinyay.entity.Book
import com.google.shinyay.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(val repository: BookRepository) {

    fun updateBookInformation(book: Book): Book {
        val persistedBook = repository.findBookByIsbn(book.isbn).get()
        persistedBook.name = book.name
        persistedBook.category = book.category
        persistedBook.price = book.price
        return repository.save(persistedBook)
    }
}