package com.example.reststudy.controller

import com.example.reststudy.dto.UserDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/get")
class GetApiController {

    // 1. 기본적인 Get 사용방법
    @GetMapping(path = ["/hello"])
    fun getHello(): String {
        return "get Hello"
    }

    // 2. 과거 Get 사용방법
    // 과거 주소 지정 방식(명시적으로 메서드를 선언해줘야 했음)
    @RequestMapping(path = ["/hi"], method = [RequestMethod.GET])
    fun hi(): String {
        return "hi~!"
    }

    // 3. path variable 받기
    // http://localhost:9090/api/get/path-variable/{name}
    @GetMapping("/path-variable/{name}")
//  fun getPathVariable(@PathVariable name: String): String {
    fun getPathVariable(@PathVariable(name = "name") pathName: String): String { // 받는 이름과 사용 이름을 다르게 설정
        return "pathVariable test :: $pathName"
    }

    // 4-1. queryParam(key, value) 받기
    // ?key=value&key2=value2
    @GetMapping("/query-param")
    fun getQueryParams(@RequestParam queryParam: Map<String, String>): String {
        var result = queryParam.map { "${it.key} = ${it.value}" }

        return "queryParams test :: $result"
    }

    // 4-2. 정해진 이름의 queryParam(key, value) 받기
    @GetMapping("/query-param02")
    fun getQueryParams02(
        @RequestParam(name = "name") name: String,
        @RequestParam(name = "email") email: String,
        @RequestParam(name = "age") age: Int,
    ): String {
        return "$name $email $age"
    }

    // 4-3. DTO를 이용해 queryParam(key, value) 받기
    @GetMapping("/query-param03")
    fun getQueryParams03(userDto: UserDto): String {
        return "${userDto.name} ${userDto.email} ${userDto.age}"
    }
}