package xyz.beriholic.kotlinwebspring

import org.babyfish.jimmer.sql.JSqlClient
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class KotlinWebSpringApplicationTests {

    @Autowired
    private lateinit var sqlClient: JSqlClient

    @Test
    fun contextLoads() {
    }


}
