package com.hamitmizrak.fullstackdeveloper12.business.services;

// Generics
public interface IForRegisterTokenEmailConfirmationServices<T> {

    // CREATE
    public String createToken(T t);

    // DELETE
    public void deleteToken(Long id);
}
