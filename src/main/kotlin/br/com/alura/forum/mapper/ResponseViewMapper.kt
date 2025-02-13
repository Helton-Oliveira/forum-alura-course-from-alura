package br.com.alura.forum.mapper

import br.com.alura.forum.DTOs.ResponseForm
import br.com.alura.forum.DTOs.ResponseView
import br.com.alura.forum.model.Response
import br.com.alura.forum.service.TopicService
import br.com.alura.forum.service.UserService
import org.springframework.stereotype.Component

@Component
class ResponseViewMapper(
    private val topicService: TopicService,
    private val userService: UserService) : Mapper<Response, ResponseView> {

    override fun map(t: Response): ResponseView {
        return ResponseView(
            id = t.id,
            message = t.message,
            solution = true,
            topicId = t.topic?.id
        )
    }

}
