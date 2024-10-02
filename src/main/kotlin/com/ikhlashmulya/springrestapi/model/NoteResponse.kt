package com.ikhlashmulya.springrestapi.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.Instant

data class NoteResponse(
    val id: String,
    val title: String,
    val content: String,
    @JsonProperty("created_at")
    val createdAt: Instant,
    @JsonProperty("updated_at")
    val updatedAt: Instant
)