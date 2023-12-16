package com.hamitmizrak.fullstackdeveloper12.business.services.impl;

import com.hamitmizrak.fullstackdeveloper12.business.services.ICustomiseUserDetails;
import com.hamitmizrak.fullstackdeveloper12.data.entity.RegisterEntity;
import com.hamitmizrak.fullstackdeveloper12.data.entity.RoleEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;


// LOMBOK
@RequiredArgsConstructor
@Log4j2

// SERVICES
@Service
public class CustomiseUserDetailsImpl implements ICustomiseUserDetails {

    private final RegisterEntity registerEntity;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // ROLE
        Set<RoleEntity> roleEntitySet=registerEntity.getRoles();

        // YETKI
        List<SimpleGrantedAuthority> simpleGrantedAuthorities= new ArrayList<>();

        // YETKILERI VER
        for(RoleEntity roleEntity: roleEntitySet){
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority(roleEntity.getRoleName()));
        }
        return simpleGrantedAuthorities;
    }


    @Override
    public String getEmail() {
        return registerEntity.getRegisterEmail();
    }

    @Override
    public String getPassword() {
        return registerEntity.getRegisterPassword();
    }

    //////////////////////////////////////////////////////////////////////
    @Override
    public Boolean isAccountNonLocked() {
        return registerEntity.getEmbeddableUserDetails().isAccountNonExpired;
    }

    @Override
    public Boolean isAccountNonExpired() {
        return registerEntity.getEmbeddableUserDetails().isAccountNonExpired;
    }

    @Override
    public Boolean isCredentialsNonExpired() {
        return registerEntity.getEmbeddableUserDetails().isAccountNonExpired;
    }

    @Override
    public Boolean isEnabled() {
        return registerEntity.getEmbeddableUserDetails().isEnabled;
    }
}
