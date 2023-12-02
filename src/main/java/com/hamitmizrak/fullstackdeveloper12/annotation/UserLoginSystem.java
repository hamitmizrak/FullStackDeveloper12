package com.hamitmizrak.fullstackdeveloper12.annotation;

import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
// NOT: @AuthenticationPrincipal  annotation yazmalısın
@AuthenticationPrincipal // Sisteme giris yapmıs kullanciilar
public @interface UserLoginSystem {

} //end class
