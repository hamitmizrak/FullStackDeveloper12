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
import com.hamitmizrak.fullstackdeveloper12.exception.HamitMizrakException;
import com.hamitmizrak.fullstackdeveloper12.exception.Resource404NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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
        RegisterEntity roleSpeedDataEntity = null; //initialize
        RegisterDto registerDto = new RegisterDto();
        // Eğer RegisterDto null değilse
        if (data != null) {
            for (int i = 1; i <= data; i++) {
                registerDto.setRegisterNickname("nick name " + i);
                registerDto.setRegisterName("name " + i);
                registerDto.setRegisterSurname("surname " + i);
                registerDto.setRegisterPassword(passwordEncoderBeanClass.passwordEncoderMethod().encode("root"));
                registerDto.setRegisterEmail("hamitmizrak" + UUID.randomUUID().toString() + "@gmail.com");
                registerDto.setRegisterIsActive(false); //mail ile aktifleştirelim
                registerDto.setIsEnabled(true);
                registerDto.setIsAccountNonExpired(true);
                registerDto.setIsCredentialsNonExpired(true);

                // Model Mapper
                RegisterEntity registerEntity = dtoToEntity(registerDto);

                // Save
                iRegisterRepository.save(registerEntity);

                // Set - Get
                registerDto.setRegisterId(registerEntity.getRegisterId());
                registerDto.setSystemCreatedDate(registerEntity.getSystemCreatedDate());
            }
            return data + " tane veri eklendi";
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
    @Transactional
    public RegisterDto registerServiceCreate(Long rolesId, RegisterDto registerDto) {
        if (registerDto != null) {

            // Model Mapper
            RegisterEntity registerEntity = dtoToEntity(registerDto);

            // Masking ( Password ) =>  Password Encoder Bean
            registerEntity.setRegisterPassword(passwordEncoderBeanClass.passwordEncoderMethod().encode(registerDto.getRegisterPassword()));

            // Öncelikle Rolü eklemelisiniz.
            int roleIdMatch = Integer.valueOf(Math.toIntExact(rolesId));
            RoleEntity roleEntity = iRoleRepository.findAll().get(roleIdMatch-1);
            Set<RoleEntity> rolList = new HashSet<>();
            rolList.add(roleEntity);
            registerEntity.setRoles(rolList);

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

    // REGISTER  LIST
    @Override
    public List<RegisterDto> registerServiceList() {
        // ENTITIY LIST
        Iterable<RegisterEntity> registerEntityIterable = iRegisterRepository.findAll();

        // DTO LIST
        List<RegisterDto> registerDtoList = new ArrayList<>();

        //forEach Loop
        for (RegisterEntity entity : registerEntityIterable) {
            // Entity Listesini ==> Dto Listesine çeviriyor
            registerDtoList.add(entityToDto(entity));
        }
        log.info("Register Liste Sayısı:" + registerDtoList.size());
        return registerDtoList;
    }

    // REGISTER  FIND ID
    @Override
    public RegisterDto registerServiceFindById(Long id) {
        // 1.YOL
        /*
        Optional<RegisterEntity> findRegisterEntityWay1=iRegisterRepository.findById(id);
        RegisterDto registerDtoWay1=entityToDto(findRegisterEntityWay1.get());
        if(findRegisterEntityWay1.isPresent()){
            return registerDtoWay1;
        }
        */

        // 2.YOL
        RegisterEntity findRegisterEntityWay2 = null;
        if (id != null) {
            findRegisterEntityWay2 = iRegisterRepository.findById(id).orElseThrow(
                    () -> new Resource404NotFoundException(id + " nolu id yoktur")
            );
        } else if (id == null) {
            throw new HamitMizrakException("id null olarak geldi");
        }
        return entityToDto(findRegisterEntityWay2);
    }

    // ROLE  UPDATE ID, OBJECT
    // @Transaction Create, Delete, Update
    @Override
    @Transactional
    public RegisterDto registerServiceUpdate(Long id, RegisterDto registerDto) {

        //Entity Instance
        RegisterEntity registerEntity = new RegisterEntity();
        registerEntity.setRegisterNickname(registerDto.getRegisterNickname());
        registerEntity.setRegisterName(registerDto.getRegisterName());
        registerEntity.setRegisterSurname(registerDto.getRegisterSurname());
        registerEntity.setRegisterEmail(registerDto.getRegisterEmail());
        registerEntity.setRegisterPassword(registerDto.getRegisterPassword());
        iRegisterRepository.save(registerEntity);
        return entityToDto(registerEntity);
    }

    // DELETE
    @Override
    @Transactional
    public RegisterDto registerServiceDeleteById(Long id) {
        // Öncelikle ilgili Register kaydını bulmalısın.
        RegisterDto registerFindDto = registerServiceFindById(id);
        if (registerFindDto != null) {
            iRegisterRepository.deleteById(id);
        }
        return registerFindDto;
    }

    //////////////////////////////////////////////////////
    // EMAIL TOKEN
}
