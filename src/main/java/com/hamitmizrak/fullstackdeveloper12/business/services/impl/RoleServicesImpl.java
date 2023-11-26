package com.hamitmizrak.fullstackdeveloper12.business.services.impl;


import com.hamitmizrak.fullstackdeveloper12.bean.ModelMapperBeanClass;
import com.hamitmizrak.fullstackdeveloper12.business.dto.RoleDto;
import com.hamitmizrak.fullstackdeveloper12.business.services.IRoleRegisterService;
import com.hamitmizrak.fullstackdeveloper12.data.entity.RoleEntity;
import com.hamitmizrak.fullstackdeveloper12.data.repository.IRoleRepository;
import com.hamitmizrak.fullstackdeveloper12.exception.HamitMizrakException;
import com.hamitmizrak.fullstackdeveloper12.exception.Resource404NotFoundException;
import lombok.RequiredArgsConstructor;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// NOT: @Transaction Create, Delete, Update

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

    //////////////////////////////////////////////////////////
    // SPEED DATA
    @Override
    public String roleSpeedData(Long data) {
        RoleEntity roleSpeedDataEntity=null; //initialize
        // RoleDto daha öncede database varsa eklemesin. NOTTTTTTTTTTTTTTTTT
        // Eğer RoleDto null değilse
        if (data != null) {
            for (int i = 1; i <=data ; i++) {
                roleSpeedDataEntity.setRoleName("role_name"+UUID.randomUUID().toString()); // Büyük karakter olarak database kaydet
                RoleEntity roleSaveSecondEntity = iRoleRepository.save(roleSpeedDataEntity);
            }
        }
        return null; // Random Null ise ; null dönder.
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
    // @Transaction Create, Delete, Update
    @Transactional //org.springFramework.Transaction.Optional
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
    } //end Create

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
    } //end List

    // ROLE  FIND ID
    @Override
    public RoleDto roleServiceFindById(Long id) {
        //1.YOL (Optional)
        /*
         Optional<RoleEntity> roleFindByIdFirstEntity =iRoleRepository.findById(id);
        if(roleFindByIdFirstEntity.isPresent()){ // isPresent: Entity veri varsa
            return  entityToDto(roleFindByIdFirstEntity.get()); //get: veriyi getirmek
        }
         */

        // 2.YOL
        boolean resultFindData=iRoleRepository.findById(id).isPresent();
        RoleEntity roleFindByIdThirdEntity=null; // initialize:
        if(id!=null){ //eğer veri varsa
            roleFindByIdThirdEntity=iRoleRepository.findById(id)
                    .orElseThrow(
                            ()->new Resource404NotFoundException(id+" nolu ID Yoktur")
                    );
            return entityToDto(roleFindByIdThirdEntity);
        }else if(id==null){
            throw new HamitMizrakException("Roles Dto null geldi ");
        }
        return null; // eğer veri yoksa null dönder
    } //end Find

    // ROLE  UPDATE ID, OBJECT
    // @Transaction Create, Delete, Update
    @Transactional //org.springFramework.Transaction.Optional
    @Override
    public RoleDto roleServiceUpdate(Long id, RoleDto roleDto) {
        // FIND
        RoleDto roleUpdateFindDto=roleServiceFindById(id);
        RoleEntity roleUpdateFindEntity=dtoToEntity(roleUpdateFindDto);
        if(roleUpdateFindEntity!=null){
            roleUpdateFindEntity.setRoleName(roleUpdateFindDto.getRoleName());
            iRoleRepository.save(roleUpdateFindEntity);
            // SET ID,  DATE
            roleDto.setRoleId(roleUpdateFindEntity.getRoleId());
            roleDto.setSystemCreatedDate(roleUpdateFindEntity.getSystemCreatedDate());
            return roleDto;
        }
        return null; //eğer veri yoksa null dönder
    } //end update

    // ROLE  DELETE ID
    // @Transaction Create, Delete, Update
    @Transactional //org.springFramework.Transaction.Optional
    @Override
    public RoleDto roleServiceDeleteById(Long id) {
        // FIND
        RoleDto roleDeleteFindDto=roleServiceFindById(id);
        RoleEntity roleDeleteFindEntity=dtoToEntity(roleDeleteFindDto);
        if(roleDeleteFindEntity!=null){
            roleDeleteFindEntity.setRoleName(roleDeleteFindDto.getRoleName());
            iRoleRepository.deleteById(id);
            // SET ID,  DATE
            roleDeleteFindDto.setRoleId(roleDeleteFindEntity.getRoleId());
            roleDeleteFindDto.setSystemCreatedDate(roleDeleteFindEntity.getSystemCreatedDate());
            return roleDeleteFindDto;
        }
        return null; //eğer veri yoksa null dönder
    }

    //////////////////////////////////////////////////////////
    // Email adresinden Kullanıcı Rolünü Bulmak
} //end class
