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
@Entity(name = "EntityNameRoles") // Sql JOIN için yazdım
@Table(name = "TableNameRoles")
// RegisterEntity(N) RoleEntity(M)
public class RoleEntity extends AuditingAwareBaseEntity implements Serializable {

    // SERILEŞTIRME
    public static final Long serialVersionUID = 1L;

    // ID: import jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleId;

    // Date ( otomatik tarih ekler)
    @CreationTimestamp // org.hibernate.annotation
    @Temporal(TemporalType.TIMESTAMP) // jakarta.persistence
    private Date systemCreatedDate;

    // Global Variable
    // ROLE NAME
    @Column(name="role_name",columnDefinition = "varchar(255) default 'USER'") //Default: USER olsun
    private String roleName;

} // end RoleEntity
