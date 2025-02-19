package br.com.alura.forum.controller

import br.com.alura.forum.DTOs.TopicByCategoryView
import br.com.alura.forum.service.TopicService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/relatories")
class RelatoryController (
    private val topicService: TopicService
){

    @GetMapping
    fun relatory(model: Model): String {
        model.addAttribute("topicByCategory",topicService.relatory())
        return "relatory"
    }
}