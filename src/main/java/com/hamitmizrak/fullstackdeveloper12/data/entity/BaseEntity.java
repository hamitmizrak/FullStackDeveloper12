package com.hamitmizrak.fullstackdeveloper12.data.entity;

import com.hamitmizrak.fullstackdeveloper12.audit.AuditingAwareBaseDto;
import lombok.Builder;

import java.io.Serializable;
import java.util.Date;


// abstract CLASS
abstract public class BaseEntity extends AuditingAwareBaseDto implements Serializable {

    // Serileştirme
    public static final Long serialVersionUID=1L;

    // ID
    protected  Long id;

    // DATE
    @Builder.Default // Lombok Default
    protected Date systemDate=new Date(System.currentTimeMillis());
} //end class