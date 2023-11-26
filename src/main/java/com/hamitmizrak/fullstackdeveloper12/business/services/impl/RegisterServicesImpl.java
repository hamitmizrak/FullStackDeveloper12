package com.hamitmizrak.fullstackdeveloper12.business.services.impl;

import com.hamitmizrak.fullstackdeveloper12.business.dto.RegisterDto;
import com.hamitmizrak.fullstackdeveloper12.business.services.IRegisterService;
import com.hamitmizrak.fullstackdeveloper12.data.entity.RegisterEntity;

import java.util.List;

public class RegisterServicesImpl implements IRegisterService<RegisterDto, RegisterEntity> {
    @Override
    public RegisterDto entityToDto(RegisterEntity registerEntity) {
        return null;
    }

    @Override
    public RegisterEntity dtoToEntity(RegisterDto registerDto) {
        return null;
    }

    @Override
    public String registerSpeedData(Long data) {
        return null;
    }

    @Override
    public String registerAllDelete() {
        return null;
    }

    @Override
    public RegisterDto registerServiceCreate(Long rolesId, RegisterDto registerDto) {
        return null;
    }

    @Override
    public List<RegisterDto> registerServiceList() {
        return null;
    }

    @Override
    public RegisterDto registerServiceFindById(Long id) {
        return null;
    }

    @Override
    public RegisterDto registerServiceUpdate(Long id, RegisterDto registerDto) {
        return null;
    }

    @Override
    public RegisterDto registerServiceDeleteById(Long id) {
        return null;
    }
}
