package com.google.shinyay

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@OpenAPIDefinition(
	info = Info(
		title = "Books API",
		description = "Spring Data JPA + H2",
		version = "v1"
	)
)
class SpringJpaKotlinApplication

fun main(args: Array<String>) {
	runApplication<SpringJpaKotlinApplication>(*args)
}
