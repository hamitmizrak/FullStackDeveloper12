// Role Const Api
import axios from "axios";

// PERSIST
const ROLE_PERSIST_URL = "role/api/v1.0.0";

// CLASS
class RoleApi {

    // ROLE API CREATE
    // http://localhost:4444/role/api/v1.0.0/create
    //@PostMapping("/create")
    roleApiCreate(roleDto) {
        return axios.post(`${ROLE_PERSIST_URL}/create`, roleDto);
    }

    // ROLE API  LIST
    // http://localhost:4444/role/api/v1.0.0/list
    // @GetMapping("/list")
    roleApiList() {
        return axios.get(`${ROLE_PERSIST_URL}/list`);
    }

    // ROLE API FIND BY ID
    // http://localhost:4444/role/api/v1.0.0/find
    // http://localhost:4444/role/api/v1.0.0/find/0
    // http://localhost:4444/role/api/v1.0.0/find/1
    //@GetMapping({"/find", "/find/{id}"})
    roleApiFindById(id) {
        return axios.get(`${ROLE_PERSIST_URL}/find/${id}`);
    }

    // ROLE API UPDATE
    // http://localhost:4444/role/api/v1.0.0/update
    // http://localhost:4444/role/api/v1.0.0/update/0
    // http://localhost:4444/role/api/v1.0.0/update/1
    //@PutMapping({"/update", "/update/{id}"})
    roleApiUpdate(id, roleDto) {
        return axios.put(`${ROLE_PERSIST_URL}/update/${id}`, categoryDto);
    }

    // ROLE API DELETE
    // http://localhost:4444/role/api/v1.0.0/delete
    // http://localhost:4444/role/api/v1.0.0/delete/0
    // http://localhost:4444/role/api/v1.0.0/delete/1
    //@DeleteMapping({"/delete", "/delete/{id}"})
    roleApiDelete(id) {
        return axios.delete(`${ROLE_PERSIST_URL}/delete/${id}`);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Email Adresinden Kulalnıcı rolünü bulsun
    //@GetMapping("/rol/{email}")
    registerEmailFidndRole(emailAddress) {
        return axios.get(`${ROLE_PERSIST_URL}//rol/${email}`);
    }

} //end class

// EXPORT DEFAULT
export default new RoleApi()