package com.hamitmizrak.fullstackdeveloper12.business.dto;

import com.hamitmizrak.fullstackdeveloper12.annotation.AnnotationUniqueEmailAddress;
import com.hamitmizrak.fullstackdeveloper12.audit.AuditingAwareBaseDto;
import com.hamitmizrak.fullstackdeveloper12.business.users.IUserDetailsData;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import java.io.Serializable;
import java.util.Date;

// LOMBOK
@Data
@Log4j2
@AllArgsConstructor
@Builder

// NOT: Validation işlemleri Dto yapalım.
// NOT: Eğer kullanıcı boşluk yazarsa trim ile almam gerekecek
// Validation Constraints Reference
// https://symfony.com/doc/current/reference/constraints.html

// REGISTER
public class RegisterDto extends AuditingAwareBaseDto implements IUserDetailsData, Serializable {

    // Serileştirme
    public static final Long serialVersionUID=1L;

    // ID
    private  Long registerId;

    // DATE
    private Date systemCreatedDate;

    // Global Variable
    // @NotEmpty:  Boş değilse
    // NICKNAME
    @NotEmpty(message = "{register.nickname.validation.constraints.NotNull.message}")
    private String regNickname;

    // NAME
    @NotEmpty(message = "{register.name.validation.constraints.NotNull.message}")
    private String regName;

    // SURNAME
    @NotEmpty(message = "{register.surname.validation.constraints.NotNull.message}")
    private String regSurname;

    // EMAIL
    @NotEmpty(message = "{register.email.validation.constraints.NotNull.message}")
    @Email(message = "{register.email.validation.constraints.regex.message}")
    @AnnotationUniqueEmailAddress
    private String regEmail;

    // PASSWORD
    @NotEmpty(message = "{register.password.validation.constraints.NotNull.message}")
    @Size(min = 7,max = 15,message = "{register.password.validation.constraints.MinMax.NotNull.message}")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).*$",message = "{register.password.pattern.validation.constraints.NotNull.message}")
    // @Positive
    private String regPassword;

    // ISACTIVE
    private Boolean regIsActive=false;

    ///////////////////////////////////////////////
    // CONSTRUCTOR (Parametresiz)
    public RegisterDto() {
    }


    // CONSTRUCTOR (Parametreli)
    public RegisterDto(String regNickname, String regName, String regSurname,
                       String regEmail, String regPassword, Boolean regIsActive) {
        this.regNickname = regNickname;
        this.regName = regName;
        this.regSurname = regSurname;
        this.regEmail = regEmail;
        this.regPassword = regPassword;
        this.regIsActive = regIsActive;
    }

    // CONSTRUCTOR (Parametreli)
    public RegisterDto(String regNickname, String regName, String regSurname,
                       String regEmail, String regPassword, Boolean regIsActive,
                       Boolean isAccountNonLocked, Boolean isAccountNonExpired,
                       Boolean isCredentialsNonExpired, Boolean isEnabled) {
        this.regNickname = regNickname;
        this.regName = regName;
        this.regSurname = regSurname;
        this.regEmail = regEmail;
        this.regPassword = regPassword;
        this.regIsActive = regIsActive;
    }

    // TOSTRING

    @Override
    public String toString() {
        return "RegisterDto{" +
                "registerId=" + registerId +
                ", systemCreatedDate=" + systemCreatedDate +
                ", regNickname='" + regNickname + '\'' +
                ", regName='" + regName + '\'' +
                ", regSurname='" + regSurname + '\'' +
                ", regEmail='" + regEmail + '\'' +
                ", regPassword='" + regPassword + '\'' +
                ", regIsActive=" + regIsActive +
                ", isAccountNonLocked=" + isAccountNonLocked() +
                ", isAccountNonExpired=" + isAccountNonExpired() +
                ", isCredentialsNonExpired=" + isCredentialsNonExpired() +
                ", isEnabled=" + isEnabled() +
                ", createdUser='" + createdUser + '\'' +
                ", createdDate=" + createdDate +
                ", lastUser='" + lastUser + '\'' +
                ", lastDate=" + lastDate +
                '}';
    }


    ///////////////////////////////////////////////
    // Kullanıcı register olduktan sonra Mail göndersin ve kullanıcı aktif etsin
    // USER DETAILS (INTERFACE)

    // Kullanıcı başlangıçta kilitli yani sisteme giremez sadece mail ile onaylanırsa aktif olur
    // @Builder.Default
    @Override
    public Boolean isAccountNonLocked() {
        return false;
    }


    // Eğer yaptığımız uygulamada kullanıcı 1 yıl kullanmazsa hesabı pasif olsun
    // Kullanıcı Hesap Süresi Doldu mu ?
    // @Builder.Default
    @Override
    public Boolean isAccountNonExpired() {
        return false;
    }

    // Kullanıcı Hesap Bilgileri Süresi (Authorization)
    // @Builder.Default
    @Override
    public Boolean isCredentialsNonExpired() {
        return false;
    }

    // Kullanıcı Sistemde mi ?  eğer login olmuşsa
    // @Builder.Default
    @Override
    public Boolean isEnabled() {
        return false;
    }
} //end class
