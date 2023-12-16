package com.hamitmizrak.fullstackdeveloper12.controller.api;


import org.springframework.http.ResponseEntity;

public interface ILoginApi<D> {

    public ResponseEntity<?> root();

    // SIGN-IN
    public ResponseEntity<D> singIn(D d);

    // LOGOUT
    public ResponseEntity<D>logout();

    // USER ACTIVE
    public ResponseEntity<D> userActive(D d);
}
