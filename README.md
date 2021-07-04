# Spring Data JPA with H2 by Kotlin

Spring Data JPA provides repository support for the Java Persistence API (JPA).
It eases development of applications that need to access JPA data sources.

This codes shows how to implement it by Kotlin.

## Description
### Dependencies
- org.springframework.boot
  - `spring-boot-starter-data-jpa`
  - `spring-boot-starter-web`
  - `spring-boot-devtools`
- `org.springdoc:springdoc-openapi-ui:1.5.9`
  - For API Document
- `com.h2database:h2`
  - In Memory Database

#### Kotlin Plugin
Gradle Plugin
```kotlin
plugins {
  kotlin("plugin.jpa") version "1.5.20"
}
```

Maven Plugin
```xml
  <plugin>
    <groupId>org.jetbrains.kotlin</groupId>
    <artifactId>kotlin-maven-plugin</artifactId>
    <configuration>
      <compilerPlugins>
        <plugin>jpa</plugin>
      </compilerPlugins>
    </configuration>
  </plugin>
```

### Application Configuration
#### H2 Database
```yaml
spring:
  h2:
    console:
      enabled: true
      path: /h2 # http://localhost:8080/h2
      settings:
        trace: false
        web-allow-others: true # Whether to enable remote access
        web-admin-password: passw0rd
  datasource:
    driver-class-name: org.h2.Driver
    url: jdbc:h2:mem:testdb;database_to_upper=false;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
    username: sa
    password:
```

#### JPA
```yaml
spring:
  jpa:
    database: h2
    show-sql: true
    database-platform: org.hibernate.dialect.H2Dialect
    hibernate:
      ddl-auto: create-drop # create and drop the schema automatically when a session is starts and ends
    properties:
      hibernate:
        dialect: org.hibernate.dialect.H2Dialect
        use_sql_comments: true
        format_sql: true
```

### Entity
Put the following annotations:
- @Entity
- @Id
- @GeneratedValue(strategy = GenerationType.AUTO)

```kotlin
@Entity
data class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    var name: String,
    val isbn: Long,
    var category: String,
    var price: Long
)
```

## Demo
### API Document
http://localhost:8080/books-api-doc

## Features

- feature:1
- feature:2

## Requirement

## Usage

## Installation

## References

## Licence

Released under the [MIT license](https://gist.githubusercontent.com/shinyay/56e54ee4c0e22db8211e05e70a63247e/raw/34c6fdd50d54aa8e23560c296424aeb61599aa71/LICENSE)

## Author

[shinyay](https://github.com/shinyay)
