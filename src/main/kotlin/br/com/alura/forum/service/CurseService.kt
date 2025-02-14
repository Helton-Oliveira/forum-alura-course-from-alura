package br.com.alura.forum.service

import br.com.alura.forum.model.Course
import br.com.alura.forum.repository.CurseRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class CurseService(private val repository: CurseRepository) {

    fun getCurseById(id: Long): Course {
        return repository.getReferenceById(id)
    }

}