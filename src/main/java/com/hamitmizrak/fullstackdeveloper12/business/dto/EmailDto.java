package com.hamitmizrak.fullstackdeveloper12.business.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import java.io.Serializable;

// LOMBOK
@Data
@Log4j2
@AllArgsConstructor
@Builder

public class EmailDto  extends BaseDto implements Serializable {

    // SERİLEŞTİRME
    public static final Long serialVersionUID = 1L;

    // EMAIL TO ( KİME ) ZORUNLU
    @NotEmpty(message = "{email.to.validation.constraints.NotNull.message}")
    private String emailTo; //KİME
    //private String[] emailToArray; //KİMLERE

    // EMAIL FROM (KİMDEN GELİYOR) ZORUNLU
    @Value("${spring.mail.username}")
    @NotEmpty(message = "{email.from.validation.constraints.NotNull.message}")
    //@Builder.Default
    private String emailFrom; //KİMDEN GELİYOR

    // EMAIL SUBJECT (KONU) ZORUNLU
    @NotEmpty(message = "{email.subject.validation.constraints.NotNull.message}")
    private String emailSubject; //KONU

    // EMAIL TEXT (İÇERİK)  ZORUNLU
    @NotEmpty(message = "{email.text.validation.constraints.NotNull.message}")
    private String emailText;

    // EMAIL CC
    private String emailCc;// CC
    private String[] emailCcArray;

    // EMAIL BCC
    private String emailBcc; //BCC
    private String[] emailBccArray;

    // IMAGE
    @Builder.Default
    private String image="image.png";

    // URL
    @Builder.Default
    private String URL="http://localhost:4444/";

} //end EmailDto
