package com.hamitmizrak.fullstackdeveloper12.controller.api;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;

public interface ILoginApi<D> {

    public ResponseEntity<?> root();

    // SIGN-IN
    public ResponseEntity<D> singIn(D d);

    // AUTHORIZATION
    public ResponseEntity<?> loginHandleAuthentication(String authorization);

    // LOGOUT
    public ResponseEntity<?>logout(HttpServletRequest request, HttpServletResponse response);

}
