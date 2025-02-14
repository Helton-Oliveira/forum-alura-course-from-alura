package br.com.alura.forum.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Response (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val message: String,
    val createdData: LocalDateTime = LocalDateTime.now(),
    @ManyToOne
    val author: User,
    @ManyToOne
    val topic: Topic? = null,
    val solution: Boolean = false
)