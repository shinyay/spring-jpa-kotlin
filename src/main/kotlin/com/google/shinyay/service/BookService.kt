package com.google.shinyay.service

import com.google.shinyay.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(val repository: BookRepository) {

}