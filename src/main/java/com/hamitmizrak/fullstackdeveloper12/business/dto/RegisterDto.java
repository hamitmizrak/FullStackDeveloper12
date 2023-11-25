package com.hamitmizrak.fullstackdeveloper12.business.dto;

import com.hamitmizrak.fullstackdeveloper12.annotation.AnnotationUniqueEmailAddress;
import com.hamitmizrak.fullstackdeveloper12.audit.AuditingAwareBaseDto;
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
public class RegisterDto extends AuditingAwareBaseDto  implements Serializable {

    // Serileştirme
    public static final Long serialVersionUID=1L;

    // ID
    private  Long registerId;

    // DATE
    private Date systemDate;

    // Global Variable
    // @NotEmpty:  Boş değilse
    // NICKNAME
    @NotEmpty(message = "{register.nickname.validation.constraints.NotNull.message}")
    private String rNickname;

    // NAME
    @NotEmpty(message = "{register.name.validation.constraints.NotNull.message}")
    private String rName;

    // SURNAME
    @NotEmpty(message = "{register.surname.validation.constraints.NotNull.message}")
    private String rSurname;

    // EMAIL
    @NotEmpty(message = "{register.email.validation.constraints.NotNull.message}")
    @Email(message = "{register.email.validation.constraints.regex.message}")
    @AnnotationUniqueEmailAddress
    private String rEmail;

    // PASSWORD
    @NotEmpty(message = "{register.password.validation.constraints.NotNull.message}")
    @Size(min = 7,max = 15,message = "{register.password.validation.constraints.MinMax.NotNull.message}")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).*$",message = "{register.password.pattern.validation.constraints.NotNull.message}")
    // @Positive
    private String rPassword;

    // ISACTIVE
    private Boolean isActive=false;

    ///////////////////////////////////////////////
    // CONSTRUCTOR (Parametresiz)
    public RegisterDto() {
    }


    // CONSTRUCTOR (Parametreli)
    public RegisterDto(String rNickname, String rName, String rSurname, String rEmail, String rPassword, Boolean isActive) {
        this.rNickname = rNickname;
        this.rName = rName;
        this.rSurname = rSurname;
        this.rEmail = rEmail;
        this.rPassword = rPassword;
        this.isActive = isActive;
    }
    // TOSTRING

    @Override
    public String toString() {
        return "RegisterDto{" +
                "rNickname='" + rNickname + '\'' +
                ", rName='" + rName + '\'' +
                ", rSurname='" + rSurname + '\'' +
                ", rEmail='" + rEmail + '\'' +
                ", rPassword='" + rPassword + '\'' +
                ", isActive=" + isActive +
                ", isAccountNonLocked=" + isAccountNonLocked +
                ", isAccountNonExpired=" + isAccountNonExpired +
                ", isCredentialsNonExpired=" + isCredentialsNonExpired +
                ", isEnabled=" + isEnabled +
                ", createdUser='" + createdUser + '\'' +
                ", createdDate=" + createdDate +
                ", lastUser='" + lastUser + '\'' +
                ", lastDate=" + lastDate +
                '}';
    }

    ///////////////////////////////////////////////
    // Kullanıcı register olduktan sonra Mail göndersin ve kullanıcı aktif etsin
    // USER DETAILS

    // Kullanıcı başlangıçta kilitli yani sisteme giremez sadece mail ile onaylanırsa aktif olur
    // @Builder.Default
    private Boolean isAccountNonLocked;

    // Eğer yaptığımız uygulamada kullanıcı 1 yıl kullanmazsa hesabı pasif olsun
    // Kullanıcı Hesap Süresi Doldu mu ?
    // @Builder.Default
    private Boolean isAccountNonExpired;

    // Kullanıcı Hesap Bilgileri Süresi (Authorization)
    // @Builder.Default
    private Boolean isCredentialsNonExpired;

    // Kullanıcı Sistemde mi ?  eğer login olmuşsa
    // @Builder.Default
    private Boolean isEnabled;

} //end class
