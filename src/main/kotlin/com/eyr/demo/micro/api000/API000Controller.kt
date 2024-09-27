package com.eyr.demo.micro.api000

import com.eyr.demo.api000.API000Service
import com.eyr.demo.micro.common.constants.AppConstant
import com.eyr.demo.micro.common.models.ApiModel
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(AppConstant.PATH_API_V1)
class API000Controller(
    private val service: API000Service
) {
    @PostMapping("API000001")
    fun api000001(
        @Valid @RequestBody body: API000Model.API000001REQ
    ): ApiModel.Response<API000Model.API000001RES> {
        return service.api000001(body)
    }
}