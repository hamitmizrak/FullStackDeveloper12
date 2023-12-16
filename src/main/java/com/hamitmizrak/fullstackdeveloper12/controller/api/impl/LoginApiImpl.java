package com.hamitmizrak.fullstackdeveloper12.controller.api.impl;

import com.hamitmizrak.fullstackdeveloper12.business.dto.RegisterDto;
import com.hamitmizrak.fullstackdeveloper12.business.services.ILoginServices;
import com.hamitmizrak.fullstackdeveloper12.controller.api.ILoginApi;
import com.hamitmizrak.fullstackdeveloper12.utils.FrontendPortUrl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// LOMBOK
@RequiredArgsConstructor

// REST
@RestController
@CrossOrigin(origins = FrontendPortUrl.REACT_FRONTEND_PORT_URL)
@RequestMapping("/login/api/v1")
public class LoginApiImpl implements ILoginApi<RegisterDto> {

    // INJECTION
    private final ILoginServices iLoginServices;

    @Override
    public ResponseEntity<?> root() {
        return ResponseEntity.status(200).body("index");
    }

    // SIGN-IN
    // http://localhost:4444/login/api/v1/signin
    @Override
    @PostMapping("/signin")
    public ResponseEntity<RegisterDto> singIn(@Valid @RequestBody RegisterDto registerDto) {
        return ResponseEntity.ok(registerDto);
    }

    // LOGOUT
    @Override
    public ResponseEntity<RegisterDto> logout() {
        return null;
    }

    // USER ACTIVE
    @Override
    public ResponseEntity<RegisterDto> userActive(RegisterDto registerDto) {
        return null;
    }
}
