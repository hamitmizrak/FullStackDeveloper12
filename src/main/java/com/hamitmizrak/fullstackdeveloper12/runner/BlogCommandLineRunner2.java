package com.hamitmizrak.fullstackdeveloper12.runner;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// LOMBOK
@RequiredArgsConstructor // Injection

@Log4j2
@Component
public class BlogCommandLineRunner2 implements CommandLineRunner {

    // Senkron(Aynı anda sadece 1 iş yapan processtir)
    private void justOneMailSend() {

    } //end justOneMailSend

    // ...= Rest parameter
    // String... = String dizisidir.
    @Override
    public void run(String... args) throws Exception {
        // Uygulama başladığında çalışmasını istediğimiz komutlar
        System.out.println("CommandLineRunner Çalıştı Sade");
        log.info("CommandLineRunner Çalıştı Sade");
        justOneMailSend();
    }

} //end class

