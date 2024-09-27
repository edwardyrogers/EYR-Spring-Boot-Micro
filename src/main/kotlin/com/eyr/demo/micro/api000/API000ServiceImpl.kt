package com.eyr.demo.micro.api000

import com.eyr.demo.api000.API000Service
import com.eyr.demo.micro.common.models.ApiModel
import org.springframework.stereotype.Service

@Service
class API000ServiceImpl : API000Service {

    override fun api000001(body: API000Model.API000001REQ): ApiModel.Response<API000Model.API000001RES> {
        return run {
            ApiModel.Response(
                payload = API000Model.API000001RES(
                    res = "Hello ${body.req}"
                )
            )
        }
    }
}