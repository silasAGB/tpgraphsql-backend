package com.ifrimastergl.tpgraphsql.controller;

import com.ifrimastergl.tpgraphsql.entity.User;
import com.ifrimastergl.tpgraphsql.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @MutationMapping
    public User login(@Argument String email, @Argument String password) {
        return authService.login(email, password);
    }

    @MutationMapping
    public User register(@Argument String email, @Argument String password) {
        return authService.register(email, password);
    }
}