package com.hamitmizrak.fullstackdeveloper12.business.dto;

import com.hamitmizrak.fullstackdeveloper12.annotation.AnnotationUniqueEmailAddress;
import com.hamitmizrak.fullstackdeveloper12.audit.AuditingAwareBaseDto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;

// LOMBOK
@Data
@Log4j2
@Builder

// REGISTER
public class RegisterDto extends AuditingAwareBaseDto  implements Serializable {

    // Serileştirme
    public static final Long serialVersionUID=1L;

    //Global Variable
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
    private String rPassword;

    // ISACTIVE
    @NotEmpty(message = "")
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
                ", createdUser='" + createdUser + '\'' +
                ", createdDate=" + createdDate +
                ", lastUser='" + lastUser + '\'' +
                ", lastDate=" + lastDate +
                '}';
    }
} //end class
