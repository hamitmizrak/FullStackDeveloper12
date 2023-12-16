package com.hamitmizrak.fullstackdeveloper12.business.services;

// D: Dto
public interface ILoginServices<D> {

    // SIGN-IN
    public D singIn(D d);

    // LOGOUT
    public D logout();

    // IS LOGIN
    public D isLogin();

}
