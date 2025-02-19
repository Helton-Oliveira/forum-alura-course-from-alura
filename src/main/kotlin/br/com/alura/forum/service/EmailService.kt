package br.com.alura.forum.service

import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service

@Service
class EmailService(private val javaMailSender: JavaMailSender ) {

    fun notify(email: String) {
        val message = SimpleMailMessage()

        message.subject = "[Alura] Resposta Recebida"
        message.text = "O seu topico foi respondido. Vamos la conferir!"
        message.setTo(email)

        javaMailSender.send(message)
    }
}