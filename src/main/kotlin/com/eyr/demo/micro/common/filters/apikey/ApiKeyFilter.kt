package com.eyr.demo.micro.common.filters.apikey

import cc.worldline.common.HsbcKeyUtil
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class ApiKeyFilter : OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val requestApiKey = request.getHeader("X-API-KEY")

        if (requestApiKey == null || requestApiKey != HsbcKeyUtil.getApiKey()) {
            response.status = HttpServletResponse.SC_UNAUTHORIZED
            return
        }

        filterChain.doFilter(request, response)
    }
}