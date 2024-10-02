package com.ikhlashmulya.springrestapi.service

import com.ikhlashmulya.springrestapi.entity.Note
import com.ikhlashmulya.springrestapi.model.CreateNoteRequest
import com.ikhlashmulya.springrestapi.model.NoteResponse
import com.ikhlashmulya.springrestapi.model.UpdateNoteRequest
import com.ikhlashmulya.springrestapi.repository.NoteRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.time.Instant
import java.util.NoSuchElementException
import java.util.UUID

@Service
class NoteService(val noteRepository: NoteRepository, val validationService: ValidationService) {

    fun create(request: CreateNoteRequest): NoteResponse {
        validationService.validate(request)

        val note = Note(UUID.randomUUID().toString(),request.title!!, request.content!!, Instant.now(), Instant.now())
        noteRepository.save(note)

        return toNoteResponse(note)
    }

    fun update(request: UpdateNoteRequest): NoteResponse {
        validationService.validate(request)

        val note = noteRepository.findById(request.id!!).orElseThrow { NoSuchElementException("note not found") }
        note.title = request.title!!
        note.content = request.content!!
        note.updatedAt = Instant.now()

        noteRepository.save(note)

        return toNoteResponse(note)
    }

    fun delete(noteId: String) {
        val note = noteRepository.findById(noteId).orElseThrow { NoSuchElementException("note not found") }

        noteRepository.delete(note)
    }

    fun findById(noteId: String): NoteResponse {
        return noteRepository.findById(noteId).map(::toNoteResponse).orElseThrow { NoSuchElementException("note not found") }
    }

    fun findAll(pageable: Pageable): Page<NoteResponse> {
        return noteRepository.findAll(pageable).map(::toNoteResponse)
    }

    private fun toNoteResponse(note: Note): NoteResponse {
        return NoteResponse(
            id = note.id,
            title = note.title,
            content = note.content,
            createdAt = note.createdAt,
            updatedAt = note.updatedAt
        )
    }
}