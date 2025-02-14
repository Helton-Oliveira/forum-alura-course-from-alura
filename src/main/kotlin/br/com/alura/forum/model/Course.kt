package br.com.alura.forum.model

import jakarta.persistence.*

@Entity
@Table(name = "courses")
data class Course (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val category: String,
)
