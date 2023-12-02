package com.hamitmizrak.fullstackdeveloper12.controller.api;

import org.springframework.http.ResponseEntity;

// D: Dto
public interface IRoleApi<D> {

    // ROLES CREATE
    public ResponseEntity<?> roleApiCreate(D d);

    // ROLES LIST
    public ResponseEntity<?> roleApiList();

    // FIND
    ResponseEntity<?> roleApiFindById(Long id);

    // UPDATE
    ResponseEntity<?> roleApiUpdate(Long id, D d);

    // ROLE DELETE
    ResponseEntity<?> roleApiDelete(Long id);

    ////////////////////////////////////////////////////////////////////////
    //Email adresinde kullanı rolünü bulmak

} //end interface
