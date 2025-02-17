package br.com.alura.forum.controller

import br.com.alura.forum.DTOs.TopicByCategoryView
import br.com.alura.forum.DTOs.TopicForm
import br.com.alura.forum.DTOs.TopicView
import br.com.alura.forum.DTOs.UpdateTopicForm
import br.com.alura.forum.service.TopicService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/topics")
class TopicController(private val service: TopicService) {

    @GetMapping
    @Cacheable("topics")
    fun list(
        @RequestParam(required = false) nameCurse: String?,
        @PageableDefault(size = 5, sort = ["createdDate"], direction = Sort.Direction.DESC) pagination: Pageable // paginacao de dados GET da api
    ): Page<TopicView> {
       return service.list(nameCurse, pagination)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): TopicView {
        return service.getOne(id)
    }

    @GetMapping("/relatory")
    fun getRelatory(): List<TopicByCategoryView>? {
        return service.relatory()
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = ["topics"], allEntries = true)
    fun create(@RequestBody @Valid dto: TopicForm, uirComponent: UriComponentsBuilder): ResponseEntity<TopicView> {
       val view = service.generate(dto)
        val uri = uirComponent.path("/topcs/${view.id}").build().toUri()
        return ResponseEntity.created(uri).body(view)
    }

    @PutMapping
    @Transactional
    @CacheEvict(value = ["topics"], allEntries = true)
    fun update(@RequestBody @Valid dto: UpdateTopicForm): ResponseEntity<TopicView> {
        val topic = service.updateTopic(dto)
        return ResponseEntity.ok().body(topic)
    }

    @DeleteMapping("/{id}")
    @CacheEvict(value = ["topics"], allEntries = true)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) {
        service.deleteTopic(id)
    }

}