package com.hamitmizrak.fullstackdeveloper12.data.entity;

import com.hamitmizrak.fullstackdeveloper12.audit.AuditingAwareBaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.hibernate.annotations.CreationTimestamp;
import java.io.Serializable;
import java.util.Date;

// LOMBOK
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2

// ENTITY
@Entity(name = "Categories") // Sql JOIN için yazdım
@Table(name = "category")

// Category(1) Blog(N)
public class BlogCategoryEntity extends AuditingAwareBaseEntity implements Serializable {

    // serileştirme
    public static final Long serialVersionUID = 1L;

    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="category_id",unique = true,nullable = false,insertable = true,updatable = false)
    private Long categoryId;

    // CATEGORY NAME
    @Column(name = "category_name")
    private String categoryName;

    // DATE
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date systemCreatedDate;

    // Constructor (parametresiz)
    // Constructor (parametreli)
    // toString

} //end class
