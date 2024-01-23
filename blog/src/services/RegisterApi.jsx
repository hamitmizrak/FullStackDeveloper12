// Register Const Api
import axios from "axios";

// PERSIST
const REGISTER_PERSIST_URL = "register/api/v1.0.0";

// CLASS
class RegisterApi {

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // SPEED DATA
    // http://localhost:4444/register/api/v1.0.0/speed/data
    //@GetMapping("/speed/data")
    registerApiSpeedData(id) {
        return axios.get(`${REGISTER_PERSIST_URL}/speed/data/${id}`);
    }

    // ALL DELETE
    // http://localhost:4444/register/api/v1.0.0/delete/all
    //@GetMapping("/all/delete")
    registerApiAllDelete() {
        return axios.get(`${REGISTER_PERSIST_URL}/delete/all`);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // REGISTER API CREATE
    // http://localhost:4444/register/api/v1.0.0/create
    //@PostMapping("/create/{roles_id}")
    registerApiCreate(rolesId, registerDto) {
        return axios.post(`${REGISTER_PERSIST_URL}/create`, registerDto);
    }

    // REGISTER API LIST
    // http://localhost:4444/register/api/v1.0.0/list
    //@GetMapping("/list")
    registerApiList() {
        return axios.get(`${REGISTER_PERSIST_URL}/list`);
    }

    // REGISTER API FIND BYID
    // http://localhost:4444/register/api/v1.0.0/find
    // http://localhost:4444/register/api/v1.0.0/find/0
    // http://localhost:4444/register/api/v1.0.0/find/1
    //@GetMapping({"/find", "/find/{id}"})
    registerApiFindById(id) {
        return axios.get(`${REGISTER_PERSIST_URL}/find/${id}`);
    }

    // REGISTER API UPDATE
    // http://localhost:4444/register/api/v1.0.0/update
    // http://localhost:4444/register/api/v1.0.0/update/0
    // http://localhost:4444/register/api/v1.0.0/update/1
    //@PutMapping({"/update", "/update/{id}"})
    registerApiUpdate(id, registerDto) {
        return axios.put(`${REGISTER_PERSIST_URL}/update/${id}`, registerDto);
    }

    // REGISTER API DELETE
    // http://localhost:4444/register/api/v1.0.0/delete
    // http://localhost:4444/register/api/v1.0.0/delete/0
    // http://localhost:4444/register/api/v1.0.0/delete/1
    //@DeleteMapping({"/delete", "/delete/{id}"})
    registerApiDelete(id) {
        return axios.delete(`${REGISTER_PERSIST_URL}/delete/${id}`);
    }

} //end class

// EXPORT DEFAULT
export default  new RegisterApi();
