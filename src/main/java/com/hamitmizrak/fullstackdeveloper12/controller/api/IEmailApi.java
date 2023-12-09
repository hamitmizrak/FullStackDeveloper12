package com.hamitmizrak.fullstackdeveloper12.controller.api;

import com.hamitmizrak.fullstackdeveloper12.business.dto.EmailDto;

// INTERFACE (IEmailApi)
// D: Dto

public interface IEmailApi <D>{

    EmailDto blogSendEmail(EmailDto emailDto);

    EmailDto blogSendAttachmentMail( EmailDto emailDto);
}
