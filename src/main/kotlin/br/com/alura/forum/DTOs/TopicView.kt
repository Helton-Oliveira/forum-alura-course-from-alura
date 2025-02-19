package br.com.alura.forum.DTOs

import java.time.LocalDate
import java.time.LocalDateTime

data class TopicView (
    var id: Long? = null,
    val title: String,
    val message: String,
    val status: String,
    val creationDate: LocalDateTime,
    val dateChange: LocalDate?
)