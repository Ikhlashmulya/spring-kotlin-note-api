package com.ikhlashmulya.springrestapi.repository

import com.ikhlashmulya.springrestapi.entity.Note
import org.springframework.data.jpa.repository.JpaRepository

interface NoteRepository: JpaRepository<Note, String>