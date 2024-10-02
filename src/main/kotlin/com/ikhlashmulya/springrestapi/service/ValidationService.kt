package com.ikhlashmulya.springrestapi.service

import jakarta.validation.ConstraintViolationException
import jakarta.validation.Validator
import org.springframework.stereotype.Service

@Service
class ValidationService(val validator: Validator) {
    fun validate(req: Any) {
        val constraintViolations = validator.validate(req)
        if (constraintViolations.size > 0) {
            throw ConstraintViolationException(constraintViolations)
        }
    }
}