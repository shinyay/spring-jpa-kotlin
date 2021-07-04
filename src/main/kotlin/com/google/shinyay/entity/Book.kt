package com.google.shinyay.entity

import io.swagger.v3.oas.annotations.media.Schema
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
@Schema(title = "Book Schema", description = "Book for JPA")
data class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(description = "Auto Generated ID")
    val id: Long,
    @Schema(description = "Book Name", example = "Spring Tutorial")
    var name: String,
    @Schema(description = "Book ISBN", example = "12345")
    val isbn: Long,
    @Schema(description = "Book Category", example = "Technology")
    var category: String,
    @Schema(description = "Book Price", example = "1000")
    var price: Long
)
