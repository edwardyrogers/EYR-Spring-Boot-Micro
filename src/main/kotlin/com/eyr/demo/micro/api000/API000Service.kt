package com.eyr.demo.api000

import com.eyr.demo.micro.api000.API000Model
import com.eyr.demo.micro.common.models.ApiModel

interface API000Service {
    fun api000001(body: API000Model.API000001REQ): ApiModel.Response<API000Model.API000001RES>
}