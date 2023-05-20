package com.usc.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usc.http.Response;

@RestController
public class AuthController {
    @GetMapping("/checklogin")
    public Response checkLogin(Authentication authentication) {
        return new Response(authentication != null);
    }
}
