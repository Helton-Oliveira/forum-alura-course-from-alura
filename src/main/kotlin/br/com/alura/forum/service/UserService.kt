package br.com.alura.forum.service

import br.com.alura.forum.model.User
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(var users: List<User>) {
    init {
        val user = User (
            id = 1,
            name = "Rich Richards",
            email = "mrFantastic@quartet.com"
        )

        users = Arrays.asList(user)
    }

    fun getAuthorById(id: Long): User {
        return users.stream().filter {
                u -> u.id == id
        }.findFirst().get()
    }
}