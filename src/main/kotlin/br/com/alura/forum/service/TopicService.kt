package br.com.alura.forum.service

import br.com.alura.forum.DTOs.TopicForm
import br.com.alura.forum.DTOs.TopicView
import br.com.alura.forum.DTOs.UpdateTopicForm
import br.com.alura.forum.exception.NotFoundException
import br.com.alura.forum.mapper.TopicFormMapper
import br.com.alura.forum.mapper.TopicViewMapper
import br.com.alura.forum.model.Topic
import org.springframework.stereotype.Service

@Service
class TopicService(
    private var topics: List<Topic> = ArrayList(),
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper: TopicFormMapper,
    private val notFoundMessage: String = "Tópico não encontrado"
) {

    fun list(): List<TopicView> {
        return topics.stream().map {
            t -> topicViewMapper.map(t)
        }.toList()
    }

    fun getOne(id: Long): TopicView {
        val topic = topics.stream().filter { t ->
            t.id == id
        }.findFirst().orElseThrow{NotFoundException(notFoundMessage)}

        return topicViewMapper.map(topic)
    }

    fun generate(form: TopicForm): TopicView {
        val topic = topicFormMapper.map(form)
        topic.id = topics.size.toLong() + 1
        val topics = topics.plus(topic)
        return topicViewMapper.map(topic)
    }

    fun updateTopic(dto: UpdateTopicForm): TopicView {
        val topic = topics.stream().filter { t ->
            t.id == dto.id
        }.findFirst().orElseThrow{NotFoundException(notFoundMessage)}

        topics = topics.minus(topic).plus(topic)
        return topicViewMapper.map(topic)
    }

    fun deleteTopic(id: Long) {
        val topic = topics.stream().filter { t ->
            t.id == id
        }.findFirst().orElseThrow{NotFoundException(notFoundMessage)}
        topics = topics.minus(topic)
    }
}