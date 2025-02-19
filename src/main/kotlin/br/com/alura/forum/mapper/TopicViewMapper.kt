package br.com.alura.forum.mapper

import br.com.alura.forum.DTOs.TopicView
import br.com.alura.forum.model.Topic
import org.springframework.stereotype.Component

@Component
class TopicViewMapper : Mapper<Topic, TopicView> {

    override fun map(t: Topic): TopicView {
        return TopicView(
            id = t.id,
            title = t.title,
            message = t.message,
            creationDate = t.createdDate,
            status = t.status.toString(),
            dateChange = t.dateChange,
            )
    }

}