package br.com.alura.forum.model

import java.time.LocalDateTime

data class Topic (
    var id: Long? = null,
    val title: String,
    val message: String,
    val createdDate: LocalDateTime = LocalDateTime.now(),
    val course: Course,
    val author: User,
    val status: TopicStatus = TopicStatus.NAO_RESPONDIDO,
    val responses: List<Response> = ArrayList<Response>()
)