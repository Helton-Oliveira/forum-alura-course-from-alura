package br.com.alura.forum.DTOs

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class ResponseForm (
    @field:NotBlank val message: String,
    @field:NotNull val authorId: Long,
    @field:NotNull val topicId: Long
)