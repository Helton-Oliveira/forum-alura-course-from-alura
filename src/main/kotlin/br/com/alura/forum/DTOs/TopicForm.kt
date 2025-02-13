package br.com.alura.forum.DTOs

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class TopicForm (
    @field:NotBlank @Size(min = 5, max = 200) val title: String,
    @field:NotBlank val message: String,
    @field:NotNull val idCurse: Long,
    @field:NotNull val authorId: Long
)