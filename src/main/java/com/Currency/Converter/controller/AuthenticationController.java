package com.Currency.Converter.controller;

import com.Currency.Converter.model.dto.AuthenticationResponse;
import com.Currency.Converter.utils.JWTUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("authenticate")
@AllArgsConstructor
public class AuthenticationController {

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping
    public AuthenticationResponse authenticate(@RequestParam("userName") String userName, @RequestParam("password") String password) throws Exception {

        String jwt = jwtUtil.generateToken(userName);

        return new AuthenticationResponse(jwt);
    }
}
