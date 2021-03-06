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
- `org.springdoc:springdoc-openapi-kotlin:1.5.9`
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

|GenerationType|Description|
|--------------|-----------|
|GenerationType.IDENTITY|This strategy relies on the database auto-increment column|
|GenerationType.SEQUENCE|JPA generates the primary key using a database sequence. We first need to create a sequence on the database.|
|GenerationType.TABLE|This strategy generates the primary key from a table. We need to create a generator table on the database.|
|GenerationType.AUTO|The JPA provider will choose an appropriate strategy for the underlying database|

The `IDENTITY` strategy is supported by MySQL, SQL Server, PostgreSQL, DB2, Derby, and Sybase.

### Repository
- `CrudRepository`: mainly provides CRUD functions.
- `PagingAndSortingRepository`: provides methods to do pagination and sorting records.
- `JpaRepository`: provides some JPA-related methods such as flushing the persistence context and deleting records in a batch.

```kotlin
@Repository
interface BookRepository : JpaRepository<Book, Long> {
    fun findBookByIsbn(isbn: Long): Optional<Book>
}
```

## Demo
### REST API Operation with curl
#### POST
```shell
$ curl -X POST -H "Content-Type: application/json" -d '{"name":"Spring Tutorial","isbn":123456,"category":"technology","price":1000}' localhost:8080/api/v1/books
```

#### GET
```shell
$ curl -X GET "http://localhost:8080/api/v1/books"
```

### API Document
http://localhost:8080/books-api-doc

## Features

- feature:1
- feature:2

## Requirement

## Usage

## Installation

## References
- [OpenAPI 3 and Spring Boot](https://springdoc.org/)
## Licence

Released under the [MIT license](https://gist.githubusercontent.com/shinyay/56e54ee4c0e22db8211e05e70a63247e/raw/34c6fdd50d54aa8e23560c296424aeb61599aa71/LICENSE)

## Author

[shinyay](https://github.com/shinyay)
