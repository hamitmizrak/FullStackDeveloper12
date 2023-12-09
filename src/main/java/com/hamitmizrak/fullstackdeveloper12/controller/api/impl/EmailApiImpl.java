package com.hamitmizrak.fullstackdeveloper12.controller.api.impl;

import com.hamitmizrak.fullstackdeveloper12.business.dto.EmailDto;
import com.hamitmizrak.fullstackdeveloper12.business.services.IEmailServices;
import com.hamitmizrak.fullstackdeveloper12.controller.api.IEmailApi;
import com.hamitmizrak.fullstackdeveloper12.utils.FrontendPortUrl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

// LOMBOK
@RequiredArgsConstructor

// REST
@RestController
@CrossOrigin(origins = FrontendPortUrl.REACT_FRONTEND_PORT_URL)
@RequestMapping("/email/api/v1")
public class EmailApiImpl implements IEmailApi<EmailDto> {

    // INJECTION
    private final IEmailServices iEmailServices;

    // http://localhost:4444/email/api/v1/basic/email
    @Override
    @PostMapping("/basic/email")
    //@PreAuthorize("hasPermission(#article, 'isEditor')")
    public EmailDto blogSendEmail(@Valid @RequestBody EmailDto emailDto) {
        return (EmailDto) iEmailServices.blogSendBasicEmail(emailDto);
    }

    // http://localhost:4444/email/api/v1/attachment/email
    @Override
    @PostMapping("/attachment/email")
    public EmailDto blogSendAttachmentMail(@Valid @RequestBody EmailDto emailDto) {
        return (EmailDto) iEmailServices.blogSendAttachmentMail (emailDto);
    }
} //end class
