package br.com.alura.forum.integration

import br.com.alura.forum.DTOs.TopicByCategoryView
import br.com.alura.forum.repository.TopicRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.domain.PageRequest
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.MySQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TopicRepositoryTest {

    @Autowired
    private lateinit var topicRepository: TopicRepository

    companion object {
        @Container
        private val mysqlContainer = MySQLContainer<Nothing>("mysql:8.0.33").apply{
            withDatabaseName("testdb")
            withUsername("hhl")
            withPassword("123456")
        }

        @JvmStatic
        @DynamicPropertySource
        fun properties(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url", mysqlContainer::getJdbcUrl)
            registry.add("spring.datasource.password", mysqlContainer::getPassword)
            registry.add("spring.datasource.username", mysqlContainer::getUsername)
        }
    }

   /* @Test
    fun `deve gerar um relatorio`() {
       val relatory = topicRepository.relatory()

        assertThat(relatory).isNotNull
        assertThat(relatory.first()).isExactlyInstanceOf(TopicByCategoryView::class.java)
    }*/

    @Test
    fun `Deve lista topico por nome do curso`() {
        val topic = topicRepository.findByCourseName("Kotlin avancado", PageRequest.of(0, 5))

        assertThat(topic).isNotNull
    }
}