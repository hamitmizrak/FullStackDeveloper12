package com.hamitmizrak.fullstackdeveloper12.controller.api;

import com.hamitmizrak.fullstackdeveloper12.business.dto.EmailDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IEmailApi <D>{

    EmailDto blogSendEmail(EmailDto emailDto);

    EmailDto blogSendAttachmentMail( EmailDto emailDto);
}
