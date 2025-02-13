package br.com.alura.forum.mapper

import br.com.alura.forum.DTOs.ResponseForm
import br.com.alura.forum.model.Response
import br.com.alura.forum.service.TopicService
import br.com.alura.forum.service.UserService
import org.springframework.stereotype.Component

@Component
class ResponseFormMapper(
    private val topicService: TopicService,
    private val userService: UserService) : Mapper<ResponseForm, Response> {

    override fun map(t: ResponseForm): Response {
        return Response(
            message = t.message,
            author = userService.getAuthorById(t.authorId)
        )
    }

}
