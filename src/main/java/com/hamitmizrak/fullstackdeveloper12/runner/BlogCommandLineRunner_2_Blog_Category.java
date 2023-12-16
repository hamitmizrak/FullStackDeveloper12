package com.hamitmizrak.fullstackdeveloper12.runner;

import com.hamitmizrak.fullstackdeveloper12.business.dto.BlogCategoryDto;
import com.hamitmizrak.fullstackdeveloper12.business.services.IBlogCategoryServices;
import com.hamitmizrak.fullstackdeveloper12.business.services.IBlogServices;
import com.hamitmizrak.fullstackdeveloper12.data.entity.BlogCategoryEntity;
import com.hamitmizrak.fullstackdeveloper12.data.entity.BlogEntity;
import com.hamitmizrak.fullstackdeveloper12.data.repository.IBlogCategoryRepository;
import com.hamitmizrak.fullstackdeveloper12.data.repository.IBlogRepository;
import com.hamitmizrak.fullstackdeveloper12.exception.Resource404NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;



// LOMBOK
@RequiredArgsConstructor

// Command Line Runner
@Configuration
@Log4j2
public class BlogCommandLineRunner_2_Blog_Category {

    // INJECTION
    // 1.YOL
    private final IBlogCategoryRepository iBlogCategoryRepository;
    private final IBlogRepository iBlogRepository ;

    // FIRST
    public void blogCommandLineRunnerAfterBeanMethod(){
        log.info("blog CommandLineRunner After Bean Method başladı");
        System.out.println("blog CommandLineRunner After Bean Method başladı");
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Injection
    // CommandLineRunner Metodunu çağırdım
    @Bean
    public CommandLineRunner blogCommandLineRunnerMethod() {
        // Lambda Expression
        return args -> {
            System.out.println("CommandLineRunner Çalıştı");
            log.info("Category-Blog CommandLineRunner Çalıştı");
            // Kategoriler Oluştur

            // Tekil Kategory
            BlogCategoryEntity computerCategory=new BlogCategoryEntity();
            computerCategory.setCategoryName("Bilgisayar");
            iBlogCategoryRepository.save(computerCategory);

            BlogCategoryEntity tabletCategory=new BlogCategoryEntity();
            tabletCategory.setCategoryName("Tablet");
            iBlogCategoryRepository.save(tabletCategory);

            // Blog-1
            BlogEntity blogEntity=new BlogEntity();
            blogEntity.getBlogEntityEmbeddable().setHeader("Header-1");
            blogEntity.getBlogEntityEmbeddable().setContent("Content-1");
            blogEntity.getBlogEntityEmbeddable().setTitle("Title-1");
            blogEntity.setRelationCategoryEntity(computerCategory);
            iBlogRepository.save(blogEntity);

            // Blog-2
            BlogEntity blogEntity2=new BlogEntity();
            blogEntity2.getBlogEntityEmbeddable().setHeader("Header-2");
            blogEntity2.getBlogEntityEmbeddable().setContent("Content-2");
            blogEntity2.getBlogEntityEmbeddable().setTitle("Title-2");
            blogEntity2.setRelationCategoryEntity(tabletCategory);
            iBlogRepository.save(blogEntity2);
        };
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //LAST
    public void blogCommandLineRunnerBeforeBeanMethod(){
        log.info("blog CommandLineRunner Before Bean Method bitti");
        System.out.println("blog Command Line Runner Befdre Bean Method bitti");
    }

} //end class
