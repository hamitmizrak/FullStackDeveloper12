package com.hamitmizrak.fullstackdeveloper12.runner;

import com.hamitmizrak.fullstackdeveloper12.business.services.IRoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// NOT: Roles

// LOMBOK
@RequiredArgsConstructor

@Configuration
@Log4j2
public class RolesCommandLineRunner1 {

    // INJECTION
    // 1.YOL
    private final IRoleService  iRoleService;


    // Injection
    @Bean
    //public CommandLineRunner blogCommandLineRunnerMethod(IRegisterServices iRegisterServices) {
    public CommandLineRunner rolesCommandLineRunner() {
        // Lambda Expression
        return args -> {
            System.out.println("CommandLineRunner Çalıştı");
            log.info("CommandLineRunner Çalıştı");
            //1 .YOL (Field Injection)
            iRoleService.roleSpeedData(5L);

            //2 .YOL (Parametre  IRoleService  iRoleServiceParam yazabiliriz.)
            //iRoleServiceParam.roleSpeedData(5L);
        };
    }
} //end class
