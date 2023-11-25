package com.hamitmizrak.fullstackdeveloper12.data.entity;

import com.hamitmizrak.fullstackdeveloper12.audit.AuditingAwareBaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.hibernate.annotations.CreationTimestamp;
import java.io.Serializable;
import java.util.Date;

// LOMBOK
@Data
@NoArgsConstructor
@AllArgsConstructor
@Log4j2
@Builder

// NOT: Eğer Entity'i camelCase yazarsanız RDBMS'de underscore yazarak gösterir.

// ENTITY
@Entity(name = "Registers") // Sql JOIN için yazdım
@Table(name = "registers")
public class RegisterEntity extends AuditingAwareBaseEntity implements Serializable {

    // Serileştirme
    public static final Long serialVersionUID = 1L;

    // ID: import jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "register_id")
    private Long registerId;

    // Date ( otomatik tarih ekler)
    @CreationTimestamp // org.hibernate.annotation
    @Temporal(TemporalType.TIMESTAMP) // jakarta.persistence
    private Date systemDate;

    // Global Variable
    // NICKNAME
    private String rNickname;

    // NAME
    private String rName;

    // SURNAME
    private String rSurname;

    // EMAIL
    @Column(
            name = "r_email",
            nullable = false,
            updatable = false,
            insertable = true,
            length = 50,
            columnDefinition = "varchar(255) default 'my_hamitmizrak@gmail.com'")
    private String rEmail;

    // PASSWORD
    private String rPassword;

    // ISACTIVE
    private Boolean isActive = false;

    ///////////////////////////////////////////////

    // USER DETAILS (Mail Confirmation)
    // @Embeddable
    @Embedded
    private EmbeddableUserDetails embeddableUserDetails=new EmbeddableUserDetails();

    ///////////////////////////////////////////////
    // ROLES
    // ROLE ENTITY

} //end class entity
