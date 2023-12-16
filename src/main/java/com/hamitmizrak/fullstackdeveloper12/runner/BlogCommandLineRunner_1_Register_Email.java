package com.hamitmizrak.fullstackdeveloper12.runner;

import com.hamitmizrak.fullstackdeveloper12.business.dto.RegisterDto;
import com.hamitmizrak.fullstackdeveloper12.business.services.IRegisterService;
import com.hamitmizrak.fullstackdeveloper12.data.entity.RoleEntity;
import com.hamitmizrak.fullstackdeveloper12.data.repository.IRegisterRepository;
import com.hamitmizrak.fullstackdeveloper12.data.repository.IRoleRepository;
import com.hamitmizrak.fullstackdeveloper12.role.ERole;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// LOMBOK
@RequiredArgsConstructor // Injection


// Command Line Runner
@Log4j2
@Component
// NOT: implement CommandLineRunner
public class BlogCommandLineRunner_1_Register_Email implements CommandLineRunner {

    private final IRoleRepository iRoleRepository;
    private final IRegisterRepository iRegisterRepository;
    private final IRegisterService iRegisterServices;

    // Role ve Register Eklemek
    private void rolesAndRegisterCreate() {
        synchronized (this) {
            //ROLES SUPER_ADMIN
            // Dikkat: ROLE_  eklemelisiiiin.
            Long superRoleId = iRoleRepository.save(RoleEntity.builder().roleId(0L).roleName(ERole.SUPER_ADMIN.toString()).build()).getRoleId();
            Long adminRoleId = iRoleRepository.save(RoleEntity.builder().roleId(0L).roleName(ERole.ADMIN.toString()).build()).getRoleId();
            Long writerRoleId = iRoleRepository.save(RoleEntity.builder().roleId(0L).roleName(ERole.WRITER.toString()).build()).getRoleId();
            Long userRoleId = iRoleRepository.save(RoleEntity.builder().roleId(0L).roleName(ERole.USER.toString()).build()).getRoleId();
            // Multithreading Senkron
       /* Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });*/

          for (long i = 1; i <= 4; i++) {
                //USER
                RegisterDto registerDto = new RegisterDto();
                registerDto.setRegisterNickname("computer" + i);
                registerDto.setRegisterName("Hamit" + i);
                registerDto.setRegisterSurname("Mızrak" + i);
                registerDto.setRegisterEmail("hamitmizrak" + i + "@gmail.com");
                registerDto.setRegisterPassword("Hm4444@.");

                // USERDETAILS
                registerDto.setIsAccountNonLocked(true);
                registerDto.setIsCredentialsNonExpired(false);
                registerDto.setIsAccountNonExpired(true);
                registerDto.setIsEnabled(true);

                //KAYDET
                iRegisterServices.registerServiceCreate(i, registerDto);
                System.out.println(registerDto);
                System.out.println("User Eklendi");
            } //end for
        }
    }

    @Override
    public void run(String... args) throws Exception {
        // Uygulama başladığında çalışmasını istediğimiz komutlar
        System.out.println("CommandLineRunner Çalıştı Sade");
        log.info("CommandLineRunner Çalıştı Sade");
        rolesAndRegisterCreate();
    }

} //end class

