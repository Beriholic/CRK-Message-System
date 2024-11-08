package xyz.beriholic.kotlinwebspring

import org.babyfish.jimmer.client.EnableImplicitApi
import org.babyfish.jimmer.sql.EnableDtoGeneration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableImplicitApi
@EnableDtoGeneration
class KotlinWebSpringApplication

fun main(args: Array<String>) {
    runApplication<KotlinWebSpringApplication>(*args)
}
