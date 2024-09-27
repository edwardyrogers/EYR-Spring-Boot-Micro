package com.eyr.demo.micro.common.models

import com.eyr.demo.micro.common.constants.ReturnCode
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.Instant

class ApiModel {
    open class Payload

    data class Error(
        @JsonProperty("timestamp")
        val timestamp: String = Instant.now().toString(),
        @JsonProperty("code")
        val code: ReturnCode,
        @JsonProperty("msg")
        val msg: String? = null,
        @JsonProperty("stacktrace")
        val stacktrace: String? = null,
    ) : Payload()

    data class Response<T : Payload>(
        @JsonProperty("payload")
        val payload: T,
    )
}