import axios from "axios";

// Email Const Api
const EMAIL_PERSIST_URL = "email/api/v1";

// CLASS
class EmailApi {

    // http://localhost:4444/email/api/v1/basic/email
    //@PostMapping("/basic/email")
    //@PreAuthorize("hasPermission(#article, 'isEditor')")
    blogSendEmail(emailDto) {
        return axios.post(EMAIL_PERSIST_URL + "/basic/email", emailDto);
    }

    // http://localhost:4444/email/api/v1/attachment/email
    //@PostMapping("/attachment/email")
    blogSendAttachmentMail(emailDto) {
        return axios.post(`${EMAIL_PERSIST_URL}/attachment/email`)
    }

} //end class

// Export Default Email Api
export default new EmailApi()
