package com.hamitmizrak.fullstackdeveloper12.business.services;

import java.util.List;

// D: Dto
// E: Entity
public interface IRoleRegisterService<D,E> {

    // MODEL MAPPER
    public D entityToDto(E e);
    public E dtoToEntity(D d);

    /////////////////////////
    // SPEED DATA
    public String roleSpeedData(Long data);

    // ALL DELETE
    public String roleAllDelete();

    //////////////////////////////////////////////////////////
    // ROLE CRUD
    // ROLE CREATE
    public D roleServiceCreate(D d);

    // ROLE  LIST
    public List<D> roleServiceList();

    // ROLE  FIND ID
    public D roleServiceFindById(Long id);

    // ROLE  UPDATE ID, OBJECT
    public D roleServiceUpdate(Long id, D d);

    // ROLE  DELETE ID
    public D roleServiceDeleteById(Long id);

    //////////////////////////////////////////////////////////
    // Email adresinden Kullanıcı Rolünü Bulmak

} //end class
