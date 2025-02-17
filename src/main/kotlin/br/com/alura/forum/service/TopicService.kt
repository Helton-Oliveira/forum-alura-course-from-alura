package br.com.alura.forum.service

import br.com.alura.forum.DTOs.TopicByCategoryView
import br.com.alura.forum.DTOs.TopicForm
import br.com.alura.forum.DTOs.TopicView
import br.com.alura.forum.DTOs.UpdateTopicForm
import br.com.alura.forum.exception.NotFoundException
import br.com.alura.forum.mapper.TopicFormMapper
import br.com.alura.forum.mapper.TopicViewMapper
import br.com.alura.forum.repository.TopicRepository
import jakarta.persistence.EntityManager
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class TopicService(
    private val repository: TopicRepository,
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper: TopicFormMapper,
    private val notFoundMessage: String = "Tópico não encontrado",
    private val manager: EntityManager
) {

    fun list(nameCurse: String?, pagination: Pageable): Page<TopicView> {
        val topics = if(nameCurse == null) {
             repository.findAll(pagination)
        } else {
            repository.findByCourseName(nameCurse, pagination)
        }
        return topics.map { t ->
            topicViewMapper.map(t)
        }
    }

    fun getOne(id: Long): TopicView {
        val topic = repository.findById(id).orElseThrow{NotFoundException(notFoundMessage)}
        return topicViewMapper.map(topic)
    }

    fun generate(form: TopicForm): TopicView {
        val topic = topicFormMapper.map(form)
        val newTopic = repository.save(topic)
        return topicViewMapper.map(newTopic)
    }

    fun updateTopic(dto: UpdateTopicForm): TopicView {
        val topic = repository.findById(dto.id)
            .orElseThrow { NotFoundException(notFoundMessage) }
        topic.updateData(newTitle = dto.title, newMessage = dto.message)
        val topicUpdated = repository.save(topic)
        return topicViewMapper.map(topicUpdated)
    }

    fun deleteTopic(id: Long) {
        if(repository.existsById(id)) {
            repository.deleteById(id)
        }
    }

    fun relatory(): List<TopicByCategoryView>?{
        // return repository.relatory()
        return null
    }


}