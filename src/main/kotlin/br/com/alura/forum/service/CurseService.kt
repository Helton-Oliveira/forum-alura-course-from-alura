package br.com.alura.forum.service

import br.com.alura.forum.model.Course
import org.springframework.stereotype.Service
import java.util.*

@Service
class CurseService(var curses: List<Course>) {

    init {
        val curse = Course (
            id = 1,
            name = "Kotlin",
            category = "Programming"
        )

       curses = Arrays.asList(curse)
    }

    fun getCurseById(id: Long): Course {
        return curses.stream().filter {
            c -> c.id == id
        }.findFirst().get()
    }

}