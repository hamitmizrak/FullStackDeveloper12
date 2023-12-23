import axios from "axios";

// Login Const Api
const LOGIN_PERSIST_URL = "login/api/v1";

// CLASS
class LoginApi {

    // http://localhost:4444/login/api/v1.0.0/root
    //@GetMapping("root")
    root() {
        return axios.get(`${LOGIN_PERSIST_URL}/root`);
    }

    ////////////////////////////////////////////////////////////////////////////////////////
    // Load User By Username
    //@GetMapping("/user/details/username")
    loadUserByUsername(username) {
        return axios.get(`${LOGIN_PERSIST_URL}/user/details/username`, username);
    }

    ////////////////////////////////////////////////////////////////////////////////////////
    // SIGN-IN
    // http://localhost:4444/login/api/v1.0.0/signin
    //@PostMapping("/signin")
    singIn(registerDto) {
        return axios.post(`${LOGIN_PERSIST_URL}/signin`, registerDto);
    }

    // IS LOGIN ?
    // http://localhost:4444/login/api/v1.0.0/islogin
    //@PostMapping("/islogin")
    isLogin() {
        return axios.post(`${LOGIN_PERSIST_URL}/islogin`);
    }

    // LOGOUT
    // http://localhost:4444/login/api/v1.0.0/logout
    // @GetMapping("/logout")
    logout(request, response) {
        return axios.get(`${LOGIN_PERSIST_URL}/logout`);
    }

    //////////////////////////////////////////////////////////////////////////////////////
    // BASIC AUTHENTICATION (loginHandleAuthentication)
    // http://localhost:4444/login/api/v1.0.0/authentication
    //@PostMapping("/authentication")
    basicAuthentication(authorization) {
        return axios.get(`${LOGIN_PERSIST_URL}/logout`, authorization);
    }

} // end class

// EXPORT DEFAULT
export default new LoginApi()