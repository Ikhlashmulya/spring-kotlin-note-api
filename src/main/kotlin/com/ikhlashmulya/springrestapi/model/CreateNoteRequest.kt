package com.ikhlashmulya.springrestapi.model

import jakarta.validation.constraints.NotBlank

data class CreateNoteRequest(
    @field:NotBlank
    val title: String?,
    @field:NotBlank
    val content: String?
)