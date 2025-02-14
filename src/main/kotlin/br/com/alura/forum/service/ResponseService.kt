package br.com.alura.forum.service

import br.com.alura.forum.DTOs.ResponseForm
import br.com.alura.forum.DTOs.ResponseView
import br.com.alura.forum.DTOs.UpdateResponseForm
import org.springframework.stereotype.Service

@Service
class ResponseService {

    fun list(): List<ResponseView> {
        TODO()
    }

    fun getOne(id: Long): ResponseView {
        TODO("Not yet implemented")
    }

    fun generate(dto: ResponseForm): ResponseView {
        TODO("Not yet implemented")
    }

    fun updateTopic(dto: UpdateResponseForm): ResponseView {
        TODO("Not yet implemented")
    }

    fun deleteTopic(id: Long) {
        TODO()
    }


}
