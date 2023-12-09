package com.hamitmizrak.fullstackdeveloper12.data.embedded;

import com.hamitmizrak.fullstackdeveloper12.business.users.IUserDetailsData;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

// LOMBOK
@Getter
@Setter

// Embeddable
@Embeddable
public class EmbeddableUserDetails implements IUserDetailsData {

    // Kullanıcı başlangıçta kilitli yani sisteme giremez sadece mail ile onaylanırsa aktif olur
    // @Builder.Default
    @Override
    public Boolean isAccountNonLocked(Boolean result) {
        return result;
    }

    // Eğer yaptığımız uygulamada kullanıcı 1 yıl kullanmazsa hesabı pasif olsun
    // Kullanıcı Hesap Süresi Doldu mu ?
    // @Builder.Default
    @Override
    public Boolean isAccountNonExpired(Boolean result) {
        return result;
    }

    // Kullanıcı Hesap Bilgileri Süresi (Authorization)
    // @Builder.Default
    @Override
    public Boolean isCredentialsNonExpired(Boolean result) {
        return result;
    }

    // Kullanıcı Sistemde mi ?  eğer login olmuşsa
    // @Builder.Default
    @Override
    public Boolean isEnabled(Boolean result) {
        return result;
    }

} //end EmbeddableUserDetails
