// Blog Category Const Api
import axios from "axios";

// PERSISTENCE DATA => Dikkat persist url'in başına Rootu yazmayı unutma (/)
const BLOG_CATEGORY_PERSIST_URL = "/blog/category/api/v1";

// CLASS
class BlogCategoryApi {

    // SPEED DATA
    // http://localhost:4444/blog/category/api/v1/speed/10
    //@GetMapping(value="/speed/{id}")
    categoryApiSpeedData(id) {
        return axios.get(`${BLOG_CATEGORY_PERSIST_URL}/speed/${id}`);
    }

    // ALL DELETE
    // http://localhost:4444/blog/category/api/v1/delete/all
    //@DeleteMapping(value="/delete/all")
    categoryApiAllDelete() {
        return axios.get(`${BLOG_CATEGORY_PERSIST_URL}/delete/all`);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // CREATE
    // http://localhost:4444/blog/category/api/v1/create
    //@PostMapping("/create")
    categoryApiCreate(categoryDto) {
        return axios.post(`${BLOG_CATEGORY_PERSIST_URL}/create`, categoryDto);
    }

    // LIST
    // http://localhost:4444/blog/category/api/v1/list
    //@GetMapping(value="/list")
    categoryApiList() {
        return axios.get(`${BLOG_CATEGORY_PERSIST_URL}/list`);
    }

    // FIND
    // http://localhost:4444/blog/category/api/v1/find/1
    //@GetMapping(value="/find/{id}")
    categoryApiFindById(id) {
        return axios.get(`${BLOG_CATEGORY_PERSIST_URL}/find/${id}`);
    }

    // UPDATE
    // http://localhost:4444/blog/category/api/v1/update/1
    //@PutMapping(value="/update/{id}")
    categoryApiUpdate(id, categoryDto) {
        return axios.put(`${BLOG_CATEGORY_PERSIST_URL}/update/${id}`, categoryDto);
    }

    // DELETE BY ID
    // http://localhost:4444/blog/category/api/v1/delete/1
    //@DeleteMapping(value="/delete/{id}")
    categoryApiDeleteById(id) {
        return axios.delete(`${BLOG_CATEGORY_PERSIST_URL}/delete/${id}`);
    }

} //end class

// EXPORT DEFAULT
export default new BlogCategoryApi();
