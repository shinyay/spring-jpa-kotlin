package com.google.shinyay.repository

import com.google.shinyay.entity.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface BookRepository : JpaRepository<Book, Long> {
    fun findBookByIsbn(isbn: Long): Optional<Book>
}