package com.hamitmizrak.fullstackdeveloper12.business.services.impl;

import com.hamitmizrak.fullstackdeveloper12.business.dto.RegisterDto;
import com.hamitmizrak.fullstackdeveloper12.business.services.ILoginServices;
import com.hamitmizrak.fullstackdeveloper12.data.entity.RegisterEntity;
import com.hamitmizrak.fullstackdeveloper12.data.entity.RoleEntity;
import com.hamitmizrak.fullstackdeveloper12.data.repository.IRegisterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

// LOMBOK
@RequiredArgsConstructor
@Log4j2

/*
UserDetailsService: Sisteme Login Girmiş kullanıcı bilgilerini almak
 */

// SERVICE
// Asıl iş Yükünü yapan yer
@Service
@Component("emailServicesImpl") //Spring'in bir parçasıdır.
public class LoginServicesImpl implements UserDetailsService, ILoginServices<RegisterDto>  {

    // INJECTION
    private final IRegisterRepository iRegisterRepository;

    //////////////////////////////////////////////////////////////////////
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        RegisterEntity registerEntity=iRegisterRepository.findByRegisterEmail(email).orElseThrow(()-> new UsernameNotFoundException("Kullanıcı bulunamadı"));
        return new CustomiseUserDetailsImpl(registerEntity);
    }

    //////////////////////////////////////////////////////////////////////
    // SIGN-IN
    @Override
    public RegisterDto singIn(RegisterDto registerDto) {
        return null;
    }

    // LOGOUT
    @Override
    public RegisterDto logout() {
        return null;
    }

    // IS LOGIN
    @Override
    public RegisterDto isLogin() {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        if(authentication!=null && authentication.isAuthenticated()){
            System.out.println(authentication.getName());
            System.out.println(authentication.getPrincipal());
        }
        RegisterDto registerDto=RegisterDto.builder()
                .registerName(authentication.getName())
                .build();
        return registerDto;
    }

} //end services
