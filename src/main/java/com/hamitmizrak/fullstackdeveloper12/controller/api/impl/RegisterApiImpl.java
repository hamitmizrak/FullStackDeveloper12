package com.hamitmizrak.fullstackdeveloper12.controller.api.impl;

import com.hamitmizrak.fullstackdeveloper12.business.dto.RegisterDto;
import com.hamitmizrak.fullstackdeveloper12.business.dto.RoleDto;
import com.hamitmizrak.fullstackdeveloper12.business.services.IRegisterService;
import com.hamitmizrak.fullstackdeveloper12.business.services.IRoleService;
import com.hamitmizrak.fullstackdeveloper12.controller.api.IRegisterApi;
import com.hamitmizrak.fullstackdeveloper12.controller.api.IRoleApi;
import com.hamitmizrak.fullstackdeveloper12.data.entity.RegisterEntity;
import com.hamitmizrak.fullstackdeveloper12.data.repository.IRegisterRepository;
import com.hamitmizrak.fullstackdeveloper12.error.ApiResult;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

// LOMBOK
@RequiredArgsConstructor
@Log4j2

// API
@RestController
@RequestMapping("/register/api/v1.0.0")
@CrossOrigin
//@CrossOrigin(origins = FrontendPortUrl.REACT_FRONTEND_PORT_URL) // http://localhost:3000
public class RegisterApiImpl implements IRegisterApi<RegisterDto> {

    // INJECTION
    private final IRegisterService iRegisterService;

    // ERROR
    private ApiResult apiResult;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // SPEED DATA
    // http://localhost:4444/register/api/v1.0.0/speed/data
    @Override
    @GetMapping("/speed/data")
    public ResponseEntity<?> registerApiSpeedData(Long key) {
        return ResponseEntity.ok(iRegisterService.registerSpeedData(key));
    }

    // ALL DELETE
    // http://localhost:4444/register/api/v1.0.0/speed/data
    @Override
    @GetMapping("/all/delete")
    public ResponseEntity<?> registerApiAllDelete() {
        return ResponseEntity.ok(iRegisterService.registerAllDelete());
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // REGISTER API CREATE
    // http://localhost:4444/register/api/v1.0.0/create
    @PostMapping("/create/{roles_id}")
    @Override
    public ResponseEntity<?> registerApiCreate(@PathVariable(name = "roles_id") Long id, @Valid @RequestBody RegisterDto registerDto) {
        return ResponseEntity.ok(iRegisterService.registerServiceCreate(id, registerDto)) ;
    }

    // REGISTER API LIST
    // http://localhost:4444/register/api/v1.0.0/list
    @GetMapping("/list")
    @Override
    public ResponseEntity<List<RegisterDto>> registerApiList() {
        return ResponseEntity.ok(iRegisterService.registerServiceList());
    }

    // REGISTER API FIND BYID
    // http://localhost:4444/register/api/v1.0.0/find
    // http://localhost:4444/register/api/v1.0.0/find/0
    // http://localhost:4444/register/api/v1.0.0/find/1
    @GetMapping({"/find","/find/{id}"})
    @Override
    public ResponseEntity<?> registerApiFindById(@PathVariable(name = "id", required = false) Long id) {
        return ResponseEntity.ok(iRegisterService.registerServiceFindById(id));
    }

    // REGISTER API UPDATE
    // http://localhost:4444/register/api/v1.0.0/update
    // http://localhost:4444/register/api/v1.0.0/update/0
    // http://localhost:4444/register/api/v1.0.0/update/1
    @PutMapping({"/update","/update/{id}"})
    @Override
    public ResponseEntity<?> registerApiUpdate(@PathVariable(name = "id", required = false) Long id, @Valid @RequestBody RegisterDto registerDto) {
        return ResponseEntity.ok(iRegisterService.registerServiceUpdate(id,registerDto));
    }

    // REGISTER API DELETE
    // http://localhost:4444/register/api/v1.0.0/delete
    // http://localhost:4444/register/api/v1.0.0/delete/0
    // http://localhost:4444/register/api/v1.0.0/delete/1
    @Override
    @DeleteMapping({"/delete", "/delete/{id}"})
    public ResponseEntity<?> registerApiDelete(@PathVariable(name = "id", required = false) Long id) {
        return ResponseEntity.ok(iRegisterService.registerServiceDeleteById(id));
    }

} //end class
