package com.hamitmizrak.fullstackdeveloper12.business.dto;

import com.hamitmizrak.fullstackdeveloper12.annotation.AnnotationUniqueRoleName;
import com.hamitmizrak.fullstackdeveloper12.audit.AuditingAwareBaseDto;
import com.hamitmizrak.fullstackdeveloper12.role.ERole;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;
import java.util.Date;

// NOT: Validation Dto tarafından yazıyorum.

// LOMBOK
@Data
@Log4j2
@AllArgsConstructor
@NoArgsConstructor
@Builder
// @SneakyThrows
public class RoleDto extends AuditingAwareBaseDto  implements Serializable {

    // SERILEŞTIRME
    public static final Long serialVersionUID=1L;

    // ID
    private  Long roleId;

    // DATE
    private Date systemCreatedDate;

    // Global Variable
    // @NotEmpty:  Boş değilse
    // ROLE NAME
    @NotEmpty(message = "{role.name.validation.constraints.NotNull.message}")
    @Builder.Default
    @AnnotationUniqueRoleName // Database aynı rolde bir isim varsa database ekleme
    private String roleName= ERole.USER.toString(); //default olarak USER olsun.

    // CONSTRUCTOR (Parametreli)
    public RoleDto(String roleName) {
        this.roleName = roleName;
    }
} //end class
