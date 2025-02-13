package br.com.alura.forum.DTOs

data class ResponseView (
    val id: Long? = null,
    val message: String,
    val solution: Boolean,
    val topicId: Long? = null
)
