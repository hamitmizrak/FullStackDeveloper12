package com.hamitmizrak.fullstackdeveloper12.business.dto;

import com.hamitmizrak.fullstackdeveloper12.audit.AuditingAwareBaseDto;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;

// LOMBOK
@Data
@Log4j2
@Builder
/*
register.password.validation.constraints.MinMax.NotNull.message = Register Password must  have to min: 7 characters and 15 max character.
register.password.pattern.validation.constraints.NotNull.message =Register Password must  least 1 uppercase , 1 lowercase , 1 special character
register.email.validation.constraints.NotNull.message=Register email cannot be null.
register.email.validation.constraints.unique.message=Register have to unique email
register.email.validation.constraints.regex.message=Register for email please write appropriate format
 */

// REGISTER
public class RegisterDto extends AuditingAwareBaseDto  implements Serializable {

    // Serileştirme
    public static final Long serialVersionUID=1L;

    //Global Variable
    @NotEmpty(message = "{register.nickname.validation.constraints.NotNull.message}")
    private String rNickname;

    @NotEmpty(message = "{register.name.validation.constraints.NotNull.message}")
    private String rName;

    @NotEmpty(message = "{register.surname.validation.constraints.NotNull.message}")
    private String rSurname;

    @NotEmpty(message = "")
    private String rEmail;

    @NotEmpty(message = "{register.password.validation.constraints.NotNull.message}")
    private String rPassword;

    @NotEmpty(message = "")
    private Boolean isActive=false;
}
