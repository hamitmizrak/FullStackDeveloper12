package com.hamitmizrak.fullstackdeveloper12.data.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

// LOMBOK
@Getter
@Setter

// Embeddable
@Embeddable
public class EmbeddableUserDetails {

    // Kullanıcı register olduktan sonra Mail göndersin ve kullanıcı aktif etsin
    // USER DETAILS

    // Kullanıcı başlangıçta kilitli yani sisteme giremez sadece mail ile onaylanırsa aktif olur
    // @Builder.Default
    private Boolean isAccountNonLocked=false;

    // Eğer yaptığımız uygulamada kullanıcı 1 yıl kullanmazsa hesabı pasif olsun
    // Kullanıcı Hesap Süresi Doldu mu ?
    // @Builder.Default
    private Boolean isAccountNonExpired=true;

    // Kullanıcı Hesap Bilgileri Süresi (Authorization)
    // @Builder.Default
    private Boolean isCredentialsNonExpired=true;

    // Kullanıcı Sistemde mi ?  eğer login olmuşsa
    // @Builder.Default
    private Boolean isEnabled=true;
} //end EmbeddableUserDetails
