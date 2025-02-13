package br.com.alura.forum.mapper

import br.com.alura.forum.DTOs.TopicForm
import br.com.alura.forum.model.Topic
import br.com.alura.forum.service.CurseService
import br.com.alura.forum.service.UserService
import org.springframework.stereotype.Component

@Component
class TopicFormMapper(
    private val curseService: CurseService,
    private val userService: UserService) : Mapper<TopicForm, Topic> {

    override fun map(t: TopicForm): Topic {
        return Topic(
            title = t.title,
            message = t.message,
            course = curseService.getCurseById(t.idCurse),
            author = userService.getAuthorById(t.authorId)
        )
    }

}
