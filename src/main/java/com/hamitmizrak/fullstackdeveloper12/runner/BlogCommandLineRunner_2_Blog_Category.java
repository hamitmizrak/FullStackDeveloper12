package com.hamitmizrak.fullstackdeveloper12.runner;

import com.hamitmizrak.fullstackdeveloper12.business.dto.RegisterDto;
import com.hamitmizrak.fullstackdeveloper12.business.services.IRegisterService;
import com.hamitmizrak.fullstackdeveloper12.data.entity.RoleEntity;
import com.hamitmizrak.fullstackdeveloper12.role.ERole;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// LOMBOK
@RequiredArgsConstructor

@Configuration
@Log4j2
public class BlogCommandLineRunner_2_Blog_Category {

    // INJECTION
    // 1.YOL
    // private final IRegisterServices iRegisterServices;

    // FIRST
    public void blogCommandLineRunnerAfterBeanMethod(){
        log.info("blog CommandLineRunner After Bean Method başladı");
        System.out.println("blog CommandLineRunner After Bean Method başladı");
    }

    // Role ve Register Eklemek
    private void blogAndBlogCategories() {
        synchronized (this) {
            // BlogCategories (Random categories)

            // Blog
        }
    }

    // Injection
    // CommandLineRunner Metodunu çağırdım
    @Bean
    public CommandLineRunner blogCommandLineRunnerMethod(IRegisterService iRegisterServices) {
        // Lambda Expression
        return args -> {
            System.out.println("CommandLineRunner Çalıştı");
            log.info("CommandLineRunner Çalıştı");
            // iRegisterServices.registerServiceSpeedData(5L);
        };
    }

    //LAST
    public void blogCommandLineRunnerBeforeBeanMethod(){
        log.info("blog CommandLineRunner Before Bean Method bitti");
        System.out.println("blog Command Line Runner Befdre Bean Method bitti");
    }

} //end class
