package br.com.alura.forum.controller

import br.com.alura.forum.DTOs.*
import br.com.alura.forum.service.ResponseService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/responses")
class ResponseController(private val service: ResponseService) {

    @GetMapping
    fun list(): List<ResponseView> {
       return service.list()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseView {
        return service.getOne(id)
    }

    @PostMapping
    fun create(@RequestBody @Valid dto: ResponseForm) {
        service.generate(dto)
    }

    @PostMapping
    fun create(@RequestBody @Valid dto: ResponseForm, uirComponent: UriComponentsBuilder): ResponseEntity<ResponseView> {
        val view = service.generate(dto)
        val uri = uirComponent.path("/responses/${view.id}").build().toUri()
        return ResponseEntity.created(uri).body(view)
    }

    @PutMapping
    fun update(@RequestBody @Valid dto: UpdateResponseForm): ResponseEntity<ResponseView> {
        val topic = service.updateTopic(dto)
        return ResponseEntity.ok().body(topic)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) {
        service.deleteTopic(id)
    }
}