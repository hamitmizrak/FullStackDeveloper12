package com.hamitmizrak.fullstackdeveloper12.runner;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// LOMBOK
@RequiredArgsConstructor

@Configuration
@Log4j2
public class BlogCommandLineRunner1 {

    // INJECTION
    // 1.YOL
    // private final IRegisterServices iRegisterServices;

    // FIRST
    public void blogCommandLineRunnerAfterBeanMethod(){
        log.info("blog CommandLineRunner After Bean Method başladı");
        System.out.println("blog CommandLineRunner After Bean Method başladı");
    }

    // Injection
    @Bean
    //public CommandLineRunner blogCommandLineRunnerMethod(IRegisterServices iRegisterServices) {
    public CommandLineRunner blogCommandLineRunnerMethod() {
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