package com.google.shinyay

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Contact
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.info.License
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@OpenAPIDefinition(
	info = Info(
		title = "Books API",
		description = "Spring Data JPA + H2",
		version = "v1",
		license = License(name = "MIT license", url = "https://bit.ly/2Tu1lFg" ),
		contact = Contact(name = "shinyay", url = "https://twitter.com/yanashin18618")
	)
)
class SpringJpaKotlinApplication

fun main(args: Array<String>) {
	runApplication<SpringJpaKotlinApplication>(*args)
}
