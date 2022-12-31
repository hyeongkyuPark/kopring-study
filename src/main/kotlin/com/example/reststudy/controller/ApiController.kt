package com.example.reststudy.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController // 해당 Class는 REST API를 처리하는 Controller
@RequestMapping("/api") // URI를 지정
class ApiController {

    @GetMapping("/hello") // http://localhost:9090/api/hello
    fun hello(): String {
        return "hello spring boot"
    }
}