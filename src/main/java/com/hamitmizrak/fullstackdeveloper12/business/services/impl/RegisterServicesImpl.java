package com.hamitmizrak.fullstackdeveloper12.business.services.impl;

import com.hamitmizrak.fullstackdeveloper12.bean.ModelMapperBeanClass;
import com.hamitmizrak.fullstackdeveloper12.bean.PasswordEncoderBeanClass;
import com.hamitmizrak.fullstackdeveloper12.business.dto.RegisterDto;
import com.hamitmizrak.fullstackdeveloper12.business.dto.RoleDto;
import com.hamitmizrak.fullstackdeveloper12.business.services.IRegisterService;
import com.hamitmizrak.fullstackdeveloper12.data.entity.RegisterEntity;
import com.hamitmizrak.fullstackdeveloper12.data.entity.RoleEntity;
import com.hamitmizrak.fullstackdeveloper12.data.repository.IRegisterRepository;
import com.hamitmizrak.fullstackdeveloper12.data.repository.IRoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

// NOT: @Transaction Create, Delete, Update

// LOMBOK
@RequiredArgsConstructor
@Log4j2

// SERVICE
// Asıl iş Yükünü yapan yer
@Service
@Component("registerServicesImpl") //Spring'in bir parçasıdır.
public class RegisterServicesImpl implements IRegisterService<RegisterDto, RegisterEntity> {

    // Injection (Lombok Constructor)
    private final ModelMapperBeanClass modelMapperBeanClass;
    private final PasswordEncoderBeanClass passwordEncoderBeanClass;
    private final IRegisterRepository iRegisterRepository;
    private final IRoleRepository iRoleRepository;


    //////////////////////////////////////////////////////////
    // MODEL MAPPER
    @Override
    public RegisterDto entityToDto(RegisterEntity registerEntity) {
        return modelMapperBeanClass.modelMapperMethod().map(registerEntity, RegisterDto.class);
    }

    @Override
    public RegisterEntity dtoToEntity(RegisterDto registerDto) {
        return modelMapperBeanClass.modelMapperMethod().map(registerDto, RegisterEntity.class);
    }


    //////////////////////////////////////////////////////////
    // SPEED DATA
    @Override
    public String registerSpeedData(Long data) {
        RegisterEntity roleSpeedDataEntity=null; //initialize
        // RoleDto daha öncede database varsa eklemesin. NOTTTTTTTTTTTTTTTTT
        // Eğer RoleDto null değilse
        if (data != null) {
            for (int i = 1; i <=data ; i++) {
                roleSpeedDataEntity.setRegNickname("nickname"+i);
                roleSpeedDataEntity.setRegName("name"+i);
                roleSpeedDataEntity.setRegSurname("surname"+i);
                roleSpeedDataEntity.setRegPassword("root");
                roleSpeedDataEntity.setREmail("email"+UUID.randomUUID().toString()+"@gmail.com");
                RegisterEntity roleSaveSecondEntity = iRegisterRepository.save(roleSpeedDataEntity);
            }
        }
        return null; // Random Null ise ; null dönder.
    }

    // ALL DELETE
    @Override
    public String registerAllDelete() {
        iRegisterRepository.deleteAll();
        return registerServiceList().size() + " kadar veri silindi.";
    }

    //////////////////////////////////////////////////////////
    // ROLE CRUD
    // ROLE CREATE
    // org.springframework.transaction.annotation.Transactional
    // @Transaction Create, Delete, Update
    @Override
    public RegisterDto registerServiceCreate(Long rolesId, RegisterDto registerDto) {
        if(registerDto!=null){
            // Model Mapper
            RegisterEntity registerEntity=dtoToEntity(registerDto);

            // Masking ( Password ) =>  Password Encoder Bean
            registerEntity.setRegPassword(passwordEncoderBeanClass.passwordEncoderMethod().encode(registerDto.getRegPassword()));

            // Öncelikle Rolü eklemelisiniz.
            int roleIdMatch=Integer.valueOf(Math.toIntExact(rolesId));
            RoleEntity roleEntity=iRoleRepository.findAll().get(roleIdMatch);
            Set<RoleEntity> roleEntities=new HashSet<>();
            roleEntities.add(roleEntity);
            registerEntity.setRoles(roleEntities);

            // SAVE
            iRegisterRepository.save(registerEntity);

            // DTO Set(ID, DATE)
            registerDto.setRegisterId(registerDto.getRegisterId());
            registerDto.setSystemCreatedDate(registerEntity.getSystemCreatedDate());

            // MAİL
           return registerDto;
        }
        return null;
    }

    // ROLE  LIST
    @Override
    public List<RegisterDto> registerServiceList() {
        return null;
    }

    // ROLE  FIND ID
    @Override
    public RegisterDto registerServiceFindById(Long id) {
        return null;
    }

    // ROLE  UPDATE ID, OBJECT
    // @Transaction Create, Delete, Update
    @Override
    public RegisterDto registerServiceUpdate(Long id, RegisterDto registerDto) {
        return null;
    }

    // DELETE
    @Override
    public RegisterDto registerServiceDeleteById(Long id) {
        return null;
    }
}
