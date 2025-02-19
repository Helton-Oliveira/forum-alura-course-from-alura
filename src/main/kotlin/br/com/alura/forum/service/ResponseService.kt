package br.com.alura.forum.service

import br.com.alura.forum.DTOs.ResponseForm
import br.com.alura.forum.DTOs.ResponseView
import br.com.alura.forum.DTOs.UpdateResponseForm
import br.com.alura.forum.mapper.ResponseFormMapper
import br.com.alura.forum.mapper.ResponseViewMapper
import br.com.alura.forum.repository.ResponseRepository
import org.springframework.stereotype.Service

@Service
class ResponseService(private val responseViewMapper: ResponseViewMapper,
                      private val responseFormMapper: ResponseFormMapper,
                      private val repository: ResponseRepository,
                      private val emailService: EmailService
) {

    fun list(): List<ResponseView> {
        TODO()
    }

    fun getOne(id: Long): ResponseView {
        TODO("Not yet implemented")
    }

    fun generate(dto: ResponseForm): ResponseView {
        val entity = responseFormMapper.map(dto)
        val newResponse = repository.save(entity)
        val authorEmail = newResponse.author.email
        emailService.notify(authorEmail)
        return responseViewMapper.map(newResponse)
    }

    fun updateTopic(dto: UpdateResponseForm): ResponseView {
        TODO("Not yet implemented")
    }

    fun deleteTopic(id: Long) {
        TODO()
    }


}
