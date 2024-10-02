package com.ikhlashmulya.springrestapi.controller

import com.ikhlashmulya.springrestapi.model.CreateNoteRequest
import com.ikhlashmulya.springrestapi.model.NoteResponse
import com.ikhlashmulya.springrestapi.model.UpdateNoteRequest
import com.ikhlashmulya.springrestapi.model.WebResponse
import com.ikhlashmulya.springrestapi.service.NoteService
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class NoteController(val noteService: NoteService) {
    @PostMapping("/notes")
    fun create(@RequestBody request: CreateNoteRequest): WebResponse<NoteResponse> {
        val response = noteService.create(request)
        return WebResponse(response)
    }

    @PutMapping("/notes/{id}")
    fun update(@PathVariable("id") noteId: String, @RequestBody request: UpdateNoteRequest): WebResponse<NoteResponse> {
        request.id = noteId

        val response = noteService.update(request)

        return WebResponse(response)
    }

    @DeleteMapping("/notes/{id}")
    fun delete(@PathVariable("id") noteId: String): WebResponse<String> {
        noteService.delete(noteId)

        return WebResponse("note deleted")
    }

    @GetMapping("/notes/{id}")
    fun findById(@PathVariable("id") noteId: String): WebResponse<NoteResponse> {
        val response = noteService.findById(noteId)

        return WebResponse(response)
    }

    @GetMapping("/notes")
    fun findAll(@RequestParam(name = "page", defaultValue = "1") page: Int, @RequestParam(name = "size", defaultValue = "5") size: Int): WebResponse<List<NoteResponse>> {
        val pageable = PageRequest.of(page - 1, size)
        val response = noteService.findAll(pageable)

        return WebResponse(response.content, mapOf("page" to page, "size" to response.size, "total_item" to response.totalElements, "total_page" to response.totalPages))
    }
}