package br.com.alura.forum.repository

import br.com.alura.forum.model.Course
import org.springframework.data.jpa.repository.JpaRepository

interface CurseRepository : JpaRepository<Course, Long>