// rfce
// REACT
import React, { useEffect, useState } from 'react'

// NAVIGATE
import {useNavigate, useParams} from 'react-router-dom'

// I18N
import { withTranslation } from 'react-i18next';

// BLOG CATEGORY API
import BlogCategoryApi from "../../services/BlogCategoryApi";

// FUNCTION BLOG CATEGORY
function BlogCategoryCreate({ t, i18n, props }) {

    // REDIRECT
    const navigate = useNavigate();

    // STATE ID
    const [blogCategoryId, setblogCategorId] = useState(null);

    // PARAMS
    const updateParamsRegisterId = useParams();

    // STATE
    const [categoryName, setCategoryName] = useState(null);

    //  ERROR, MULTIPLEREQUEST, READ, SPINNER
    const [error, setError] = useState(undefined);
    const [multipleRequest, setMultipleRequest] = useState(false);
    const [isRead, setIsRead] = useState(false);
    const [spinner, setSpinner] = useState(false);

    // USE EFFECT
    useEffect(() => {
        // Params ID
        setblogCategorId(updateParamsRegisterId.id);
        // FIND
        BlogCategoryApi. categoryApiFindById(updateParamsRegisterId.id)
            .then((response) => {
                if (response.status === 200) {
                    console.log(response);
                    setCategoryName(response.data.categoryName);
                } else
                    Promise.reject()
            })
            .catch((err) => {
                console.error(err)
            })

        // başlangıçta Hatayı gösterme
        setError(undefined);
        setIsRead(false);
        setSpinner(false);
    }, [])

    // FUNCTION
    // Read On Change
    const onChangeIsRead = (event) => {
        //console.log(event.target.checked);
        setIsRead(event.target.checked);
        // 1 kere okudutan sonra daha görünmesin
        localStorage.setItem("is_read", "true")
    }

    // input List Clear
    const inputListClear = () => {
        setCategoryName(undefined)
    }

    // OnChange
    const categoryNameOnChange = (event) => {
        const { name, value } = event.target;
        //console.log(name + " " + value);
        setCategoryName(value);
    }

    // onSubmitSearch
    const onSubmitForm = (e) => {
        e.preventDefault();
    }

    //// SUBMIT
    // blogCategoryUpdateSubmit
    const blogCategoryUpdateSubmit = async (event) => {
        // Register Object
        const blogCategoryCreateObject = {
            categoryName
        }
        //console.log(blogCategoryCreateObject);

        // Hataları gösterme
        setError(null);

        // Spinner Aktif et
        setSpinner(true);

        // MultipleRequest (Aktif)
        setMultipleRequest(true);

        // API
        try {
            const response = await BlogCategoryApi.categoryApiUpdate(updateParamsRegisterId.id,blogCategoryCreateObject);
            if (response.status == 200) {
                // Spinner Pasif et
                setSpinner(false);
                // MultipleRequest (Aktif)
                setMultipleRequest(false);
                // Toast Message
                alert("Kayıt Başarılı");
                navigate('/blog/category/list');
            }
        } catch (err) {
            //console.error(err.response.data.validationErrors);
            setError(err.response.data.validationErrors)
            // Spinner Pasif et
            setSpinner(true);
            // MultipleRequest (Aktif)
            setMultipleRequest(false);
        }
    } //end

    // Spinner
    const spinnerFunction = () => {
        if (spinner) {
            return (
                <div className="spinner-border  spinner-border-sm text-warning me-2" role="status">
                </div>
            )
        } else {
            return "";
        }
    }

    //Error
    const classNameData = { error } ? "is-invalid form-control mb-3" : "form-control mb-3";
    //console.log(error);
    //console.log(registerSurname);
    //console.log(classNameData);

    // RETURN
    return (
        <React.Fragment>
            <div className="mt-5 mb-5" >
                <form onSubmit={onSubmitForm}>
                    {/* <form onSubmit="event.preventDefault()"> */}
                    <div className="d-grid gap-4">
                        {/* NICKNAME */}
                        <div className="form-group"><label htmlFor="categoryName"> {t('blog_category_name')}</label>
                            <input
                                type="text"
                                className={classNameData}
                                id="categoryName"
                                name="categoryName"
                                placeholder={t('blog_category_name')}
                                autoFocus={true}
                                required={true}
                                onChange={categoryNameOnChange}
                                /*onChange={
                                    (event) => {
                                        const { name, value } = event.target;
                                        //console.log(`${name} => ${value}`);
                                        categoryNameOnChange(event.target.value);
                                    }
                                }*/
                                value={categoryName}
                            />

                            {/* ALERT ERROR */}
                            {/* {
                            errorAlert(registerNickName)
                          } */}
                            {error ? <div className="invalid-feedback">{error.categoryName}</div> : ""}
                        </div>
                    </div>

                    {/* READ */}
                    {(localStorage.getItem("is_read") == "true") ? "" :
                        <span style={{ display: "inline" }}>
                            <input
                                type="checkbox"
                                className="form-check-input"
                                onChange={onChangeIsRead}
                                name="isRead"
                                id="isRead" />
                            <abbr title="Register Olurken Kayıt işlemleri" htmlFor="isRead">{t('is_read')}</abbr>
                            <br />
                        </span>
                    }

                    {/* RESET */}
                    <button
                        type='reset'
                        onClick={inputListClear}
                        className="btn btn-danger text-hamitmizrak-red mt-2 me-2">{t('cleaner')}</button>

                    {/* SUBMIT   */}
                    <button
                        type='submit'
                        onClick={blogCategoryUpdateSubmit}
                        className="btn text-hamitmizrak-blue btn-primary mt-2 me-2"
                        disabled={(!localStorage.getItem("is_read") == true) || (multipleRequest)}>

                        {/* SPINNER */}
                        {
                            spinnerFunction()
                        }
                        {t('submit')}
                    </button>
                </form>
            </div>
            <br /><br /><br /><br /><br /> <br /><br /><br /><br />
        </React.Fragment>
    ) // end return
}// end functıon

// Export i18n Wrapper
export default withTranslation()(BlogCategoryCreate)

