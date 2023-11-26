package com.hamitmizrak.fullstackdeveloper12.business.services.impl;


import com.hamitmizrak.fullstackdeveloper12.bean.ModelMapperBeanClass;
import com.hamitmizrak.fullstackdeveloper12.business.dto.RoleDto;
import com.hamitmizrak.fullstackdeveloper12.business.services.IRoleRegisterService;
import com.hamitmizrak.fullstackdeveloper12.data.entity.RoleEntity;
import com.hamitmizrak.fullstackdeveloper12.data.repository.IRoleRepository;
import lombok.RequiredArgsConstructor;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// LOMBOK
@RequiredArgsConstructor

// Asıl iş Yükünü yapan yer
@Service
@Component("roleServicesImpl") //Spring'in bir parçasıdır.
public class RoleServicesImpl implements IRoleRegisterService<RoleDto, RoleEntity> {

    // INJECTION
    // 1.YOL (Field Injection)
    /*
    @Autowired
    private ModelMapperBeanClass modelMapperBeanClass;

    @Autowired
    private IRoleRepository  iRoleRepository;
    */


    // 2.YOL (Constructor Injection)
    // NOT: final yazarsam beni constructor'a zorlar
    /*
    private final ModelMapperBeanClass modelMapperBeanClass;
    private final IRoleRepository  iRoleRepository;
    @Autowired
    public RoleServicesImpl(ModelMapperBeanClass modelMapperBeanClass, IRoleRepository iRoleRepository) {
        this.modelMapperBeanClass = modelMapperBeanClass;
        this.iRoleRepository = iRoleRepository;
    }
    */

    // 3.YOL (Lombok Constructor)
    private final ModelMapperBeanClass modelMapperBeanClass;
    private final IRoleRepository iRoleRepository;


    // MODEL MAPPER
    @Override
    public RoleDto entityToDto(RoleEntity roleEntity) {
        return modelMapperBeanClass.modelMapperMethod().map(roleEntity, RoleDto.class);
    }

    @Override
    public RoleEntity dtoToEntity(RoleDto roleDto) {
        return modelMapperBeanClass.modelMapperMethod().map(roleDto, RoleEntity.class);
    }

    /////////////////////////
    // SPEED DATA
    @Override
    public String roleSpeedData(Long data) {
        return null;
    }

    // ALL DELETE
    @Override
    public String roleAllDelete() {
        iRoleRepository.deleteAll();
        return roleServiceList().size() + " kadar veri silindi.";
    }

    //////////////////////////////////////////////////////////
    // ROLE CRUD
    // ROLE CREATE
    @Override
    public RoleDto roleServiceCreate(RoleDto roleDto) {
        RoleEntity roleSaveFirstEntity;
        // RoleDto daha öncede database varsa eklemesin. NOTTTTTTTTTTTTTTTTT
        // Eğer RoleDto null değilse
        if (roleDto != null) {
            roleSaveFirstEntity = dtoToEntity(roleDto);
            roleSaveFirstEntity.setRoleName(roleSaveFirstEntity.getRoleName().toUpperCase()); // Büyük karakter olarak database kaydet
            RoleEntity roleSaveSecondEntity = iRoleRepository.save(roleSaveFirstEntity);
            // SET ID,  DATE
            roleDto.setRoleId(roleSaveSecondEntity.getRoleId());
            roleDto.setSystemCreatedDate(roleSaveSecondEntity.getSystemCreatedDate());
            return roleDto;
        }
        return null; // RoleDto Null ise ; null dönder.
    }

    // ROLE  LIST
    @Override
    public List<RoleDto> roleServiceList() {
        // Entity List
        List<RoleEntity> roleListFirstEntity=iRoleRepository.findAll();
        // Dto List
        List<RoleDto> roleListFirstDto= new ArrayList<>();
        if(roleListFirstEntity.size()!=0){ // Listede Eleman varsa
            for (RoleEntity tempEntity :roleListFirstEntity) {
                RoleDto roleDtoFirst=entityToDto(tempEntity);
                roleListFirstDto.add(roleDtoFirst);
            } //end for
            return roleListFirstDto;
        } //end if
        return null; // roleListFirstEntity elaman sayısı yoksa ; null dönder.
    }

    // ROLE  FIND ID
    @Override
    public RoleDto roleServiceFindById(Long id) {
        return null;
    }

    // ROLE  UPDATE ID, OBJECT
    @Override
    public RoleDto roleServiceUpdate(Long id, RoleDto roleDto) {
        return null;
    }

    // ROLE  DELETE ID
    @Override
    public RoleDto roleServiceDeleteById(Long id) {
        return null;
    }

    //////////////////////////////////////////////////////////
    // Email adresinden Kullanıcı Rolünü Bulmak
} //end class
