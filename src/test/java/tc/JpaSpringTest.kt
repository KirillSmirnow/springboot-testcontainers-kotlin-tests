package tc

import org.testcontainers.containers.PostgreSQLContainer
import javax.transaction.Transactional

@Transactional
abstract class JpaSpringTest : SpringTest() {

    companion object JpaSpringTestConfig {

        init {
            val jpaContainer = PostgreSQLContainer<Nothing>()
            jpaContainer.start()
            System.setProperty("spring.jpa.hibernate.ddl-auto", "create-drop")
            System.setProperty("spring.datasource.url", jpaContainer.jdbcUrl)
            System.setProperty("spring.datasource.username", jpaContainer.username)
            System.setProperty("spring.datasource.password", jpaContainer.password)
        }
    }
}
