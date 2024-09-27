package com.eyr.demo.micro.common.configurations

import com.eyr.demo.micro.common.filters.apikey.ApiKeyFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
class SecurityConfiguration(
    private val apiKeyFilter: ApiKeyFilter
) {
    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        return run {
            http.csrf { csrf -> csrf.disable() }
                .authorizeHttpRequests { req ->
                    req
                        .anyRequest()
                        .permitAll()
                }
                .addFilterBefore(apiKeyFilter, UsernamePasswordAuthenticationFilter::class.java)
                .build()

        }
    }
}