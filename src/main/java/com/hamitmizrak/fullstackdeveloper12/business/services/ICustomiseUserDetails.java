package com.hamitmizrak.fullstackdeveloper12.business.services;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

// D: Dto
public interface ICustomiseUserDetails {

    // Kullanıcı İzinleri
    public Collection<? extends GrantedAuthority> getAuthorities();

    //////////////////////////////////////////////

    // User Email
    public String getEmail();

    // User Password
    public String getPassword();

    //////////////////////////////////////////////
    // Kullanıcı Kiliti
    public Boolean isAccountNonLocked();

    // Kullanıcı Süresi
    public Boolean isAccountNonExpired() ;

    // Kimlik Bilgileri Kontrol Etmek
    public Boolean isCredentialsNonExpired();

    // Kullanıcı Active mi
    public Boolean isEnabled();
}
