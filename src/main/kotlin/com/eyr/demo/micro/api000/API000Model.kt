package com.eyr.demo.micro.api000

import com.eyr.demo.micro.common.models.ApiModel
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotBlank

class API000Model {
    data class API000001REQ(
        @field: NotBlank
        val req: String = "",
    )

    data class API000001RES(
        @JsonProperty("res")
        val res: String = "",
    ) : ApiModel.Payload()
}