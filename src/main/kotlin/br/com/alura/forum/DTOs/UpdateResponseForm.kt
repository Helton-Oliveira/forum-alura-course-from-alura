package br.com.alura.forum.DTOs

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class UpdateResponseForm (
    @field:NotNull val id: Long,
    @field:NotBlank val message: String,
)
