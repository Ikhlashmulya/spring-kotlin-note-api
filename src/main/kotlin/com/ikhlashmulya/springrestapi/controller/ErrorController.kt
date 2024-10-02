package com.ikhlashmulya.springrestapi.controller

import jakarta.validation.ConstraintViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.NoHandlerFoundException
import kotlin.NoSuchElementException

@RestControllerAdvice
class ErrorController {
    @ExceptionHandler(value = [ConstraintViolationException::class])
    fun validationError(exception: ConstraintViolationException): ResponseEntity<Map<String, String?>> {
        return ResponseEntity(mapOf("errors" to exception.message), HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(value = [NoSuchElementException::class, NoHandlerFoundException::class])
    fun notFoundError(exception: Exception): ResponseEntity<Map<String, String?>> {
        return ResponseEntity(mapOf("errors" to exception.message), HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(value = [Exception::class])
    fun exception(exception: Exception): ResponseEntity<Map<String, String?>> {
        return ResponseEntity(mapOf("errors" to exception.message), HttpStatus.INTERNAL_SERVER_ERROR)
    }
}