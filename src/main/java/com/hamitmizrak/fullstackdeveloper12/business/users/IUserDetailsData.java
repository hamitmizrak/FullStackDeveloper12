package com.hamitmizrak.fullstackdeveloper12.business.users;

public interface IUserDetailsData {

    // Kullanıcı register olduktan sonra Mail göndersin ve kullanıcı aktif etsin
    // USER DETAILS

    // Kullanıcı başlangıçta kilitli yani sisteme giremez sadece mail ile onaylanırsa aktif olur
    // @Builder.Default

    public Boolean isAccountNonLocked();

    // Eğer yaptığımız uygulamada kullanıcı 1 yıl kullanmazsa hesabı pasif olsun
    // Kullanıcı Hesap Süresi Doldu mu ?
    // @Builder.Default
    public Boolean isAccountNonExpired();

    // Kullanıcı Hesap Bilgileri Süresi (Authorization)
    // @Builder.Default
    public Boolean isCredentialsNonExpired();

    // Kullanıcı Sistemde mi ?  eğer login olmuşsa
    // @Builder.Default
    public Boolean isEnabled();
}
