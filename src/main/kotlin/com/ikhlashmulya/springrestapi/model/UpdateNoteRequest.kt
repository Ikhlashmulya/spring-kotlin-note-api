package com.ikhlashmulya.springrestapi.model

import jakarta.validation.constraints.NotBlank

data class UpdateNoteRequest(
    @field:NotBlank
    var id: String?,
    @field:NotBlank
    val title: String?,
    @field:NotBlank
    val content: String?,
)