package br.com.alura.forum.model

import java.time.LocalDateTime

data class Response (
    val id: Long? = null,
    val message: String,
    val createdData: LocalDateTime = LocalDateTime.now(),
    val author: User,
    val topic: Topic? = null,
    val solution: Boolean = false
)