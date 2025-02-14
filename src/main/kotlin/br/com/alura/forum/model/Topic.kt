package br.com.alura.forum.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "topics")
data class Topic (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "title")
    var title: String,

    @Column(name = "message")
    var message: String,

    @Column(name = "created_date")
    val createdDate: LocalDateTime = LocalDateTime.now(),

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    val status: TopicStatus = TopicStatus.NAO_RESPONDIDO,

    @ManyToOne
    @JoinColumn(name = "course_id") // Nome da coluna FK
    val course: Course,

    @ManyToOne
    @JoinColumn(name = "author_id") // Nome da coluna FK
    val author: User
) {
    fun updateData(newTitle: String?, newMessage: String?) {
        if (!newTitle.isNullOrBlank()) {
            this.title = newTitle
        }

        if (!newMessage.isNullOrBlank()) {
            this.message = newMessage
        }
    }
}