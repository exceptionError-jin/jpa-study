package com.app.jpa.controller;

// Repository, Service를 수행하고 API 응답을 리턴하기 위한 컨트롤러

import com.app.jpa.entity.Users;
import com.app.jpa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    // UserService 객체를 주입받기 위한 생성자 주입 (Lombok의 @RequiredArgsConstructor로 생성자를 자동으로 생성)
    private final UserService userService;

    // HTTP GET 요청을 처리하는 핸들러 메서드
    // @GetMapping 애너테이션은 "/users" URL에 GET 요청이 오면 이 메서드가 처리
    // @RequestParam 애너테이션을 사용하여 "name" 파라미터를 받아온다.
    // name 파라미터는 선택적으로 전달 가능하며, 전달되지 않을 경우 기본값으로 빈 문자열("")을 사용한다.
    // userService.getUserService(name)을 호출하여 name에 해당하는 사용자 리스트를 조회하여 반환
    @GetMapping(value = "/users")
    public List<Users> getUsers(@RequestParam(required = false, defaultValue = "") String name) {
        return userService.getUsersService(name);
    }

    // HTTP POST 요청을 처리하는 핸들러 메서드
    // @PostMapping 애너테이션은 "/user" URL에 POST 요청이 오면 이 메서드가 처리
    // @RequestBody 애너테이션을 사용하여 HTTP 요청의 본문(body)에서 Users 객체를 받아온다.
    // userService.createUserService(user)를 호출하여 받아온 Users 객체를 저장하고 결과를 문자열로 반환
    @PostMapping(value = "/user")
    public String createUser(@RequestBody Users user) {
        return userService.createUserService(user);
    }
}
