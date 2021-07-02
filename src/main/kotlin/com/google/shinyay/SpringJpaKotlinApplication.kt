package com.google.shinyay

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringJpaKotlinApplication

fun main(args: Array<String>) {
	runApplication<SpringJpaKotlinApplication>(*args)
}
