/*package br.com.alura.forum.service

import br.com.alura.forum.exception.NotFoundException
import br.com.alura.forum.mapper.TopicFormMapper
import br.com.alura.forum.mapper.TopicViewMapper
import br.com.alura.forum.repository.TopicRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import java.util.**/

/*class TopicServiceTest

    val topics = PageImpl(listOf(TopicTest.build()))
    val pagination: Pageable = mockk()

    val topicRepository: TopicRepository = mockk {
        every { findByCourseName(any(), any()) } returns topics
        every { findAll(pagination) } returns topics
    }

    val topicViewMapper: TopicViewMapper = mockk{
        every { map(any()) } returns TopicViewMapperTest.build()
    }

    val topicFormMapper: TopicFormMapper = mockk()

    val topicService = TopicService(
        topicRepository, topicViewMapper, topicFormMapper
    )

    @Test
    fun `deve listar topicos a partir do nome do curso`() {

        topicService.list("Kotlin avançado", pagination)

        verify(exactly = 1) { topicRepository.findByCourseName(any(), any()) }
        verify(exactly = 1) { topicViewMapper.map(any()) }
        verify(exactly = 0) { topicRepository.findAll(pagination) }
    }

    @Test
    fun `deve listar todos os topicos quando o nome do curso for nulo`() {
        topicService.list(null, pagination)

        verify(exactly = 0) { topicRepository.findByCourseName(any(), any()) }
        verify(exactly = 1) { topicViewMapper.map(any()) }
        verify(exactly = 1) { topicRepository.findAll(pagination) }
    }

    @Test
    fun `deve listar not found exception quando topico nao for achado`() {
        every { topicRepository.findById(any()) } returns Optional.empty()

        val actual = assertThrows<NotFoundException> {
            topicService.getOne(1)
        }*/

/*
        assertThat(actual.message).isEqualTo("Topico nao encontrado!")
    }

}*/
