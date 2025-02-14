package br.com.alura.forum.repository

import br.com.alura.forum.DTOs.TopicByCategoryView
import br.com.alura.forum.model.Topic
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TopicRepository : JpaRepository<Topic, Long> {

    fun findByCourseName(nameCurse: String, pagination: Pageable): Page<Topic>

    @Query("SELECT new br.com.alura.forum.dto.TopicByCategory(course.category, count(t)) FROM Topic t JOIN t.course course GROUP BY course.category")
    fun relatory(): List<TopicByCategoryView>

}