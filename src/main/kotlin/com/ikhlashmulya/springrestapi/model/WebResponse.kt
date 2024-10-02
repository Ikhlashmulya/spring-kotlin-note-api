package com.ikhlashmulya.springrestapi.model

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class WebResponse<T>(
    val data: T,
    val pagination: Map<String, Number>? = null
)