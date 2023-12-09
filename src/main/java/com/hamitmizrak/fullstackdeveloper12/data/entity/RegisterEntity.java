package com.hamitmizrak.fullstackdeveloper12.data.entity;

import com.hamitmizrak.fullstackdeveloper12.audit.AuditingAwareBaseEntity;
import com.hamitmizrak.fullstackdeveloper12.data.embedded.EmbeddableUserDetails;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.hibernate.annotations.CreationTimestamp;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

// LOMBOK
@Data
@NoArgsConstructor
@AllArgsConstructor
@Log4j2
@Builder

// NOT: Eğer Entity'i camelCase yazarsanız RDBMS'de underscore yazarak gösterir.
// NOT: relation için Id ayrıca yazıyorum. BaseEntity'den otomatik almadım

// ENTITY
@Entity(name = "Registers") // Sql JOIN için yazdım
@Table(name = "registers")
// RegisterEntity(N) RoleEntity(M)
public class RegisterEntity extends AuditingAwareBaseEntity implements Serializable {

    // SERILEŞTIRME
    public static final Long serialVersionUID = 1L;

    // relation için Id ayrıca yazıyorum. BaseEntity'den otomatik almadım
    // ID: import jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "register_id")
    private Long registerId;

    // Date ( otomatik tarih ekler)
    @CreationTimestamp // org.hibernate.annotation
    @Temporal(TemporalType.TIMESTAMP) // jakarta.persistence
    private Date systemCreatedDate;

    // Global Variable
    // NICKNAME
    private String registerNickname;

    // NAME
    private String registerName;

    // SURNAME
    private String registerSurname;

    // EMAIL
    @Column(
            name = "register_email",
            nullable = false,
            updatable = false,
            insertable = true,
            length = 50,
            columnDefinition = "varchar(255) default 'my_hamitmizrak@gmail.com'")
    private String registerEmail;

    // PASSWORD
    private String registerPassword;

    // ISACTIVE
    private Boolean registerIsActive = false;

    ///////////////////////////////////////////////

    // @Embeddable
    // USER DETAILS (Mail Confirmation)
    @Embedded
    private EmbeddableUserDetails embeddableUserDetails=new EmbeddableUserDetails();

    ///////////////////////////////////////////////
    // ROLES
    // ROLE ENTITY (RELATION)
    // NOT: @ManyToMany'de RegisterEntity RolesEntity ve 1 tane ara tablo daha oluşur adı(registers_roles)

    // 1.YOL
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(
            name="registers_roles" ,
            joinColumns = @JoinColumn(name="register_id"), // RegisterEntity ID'si
            inverseJoinColumns = @JoinColumn(name="role_id") //RoleEntity ID'si
    )
    private Set<RoleEntity> roles=new HashSet<>();

    // 2.YOL
	/*
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "user_role",
	joinColumns = {
	            @JoinColumn(name = "user_id",referencedColumnName = "user_id")},
	            inverseJoinColumns = {
	                            @JoinColumn(name = "roles_id",referencedColumnName = "roles_id")
	                            }
	             )
	 private List<RoleEntity> roles;
	   */

} //end class entity
