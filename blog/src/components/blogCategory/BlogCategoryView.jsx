// React, useState
import React, { useEffect, useState } from 'react'

// i18n
import { withTranslation } from 'react-i18next'

// Router, Params
import { useNavigate, useParams } from 'react-router-dom'

//Blog Category
import BlogCategoryApi from '../../services/BlogCategoryApi';

// Image
import sunrise from '../../assets/image/sunset-8327637_1280.jpg';

// REGISTER VIEW FUNCTION
function BlogCategoryView({ props, t, i18n }) {

    // REDIRECT
    let navigate = useNavigate();

    // STATE
    const [id, setId] = useState(null);
    const [blogCategoryViewState, setblogCategoryViewState] = useState([]);

    // PARAMS (ID)
    const parametersHandlingViewId = useParams();

    // EFFECT
    useEffect(() => {
        // 1.YOL LocalStorage
        setId(localStorage.getItem("blog_category_view_id"))

        // 2.YOL useParams
        setId(parametersHandlingViewId.id);

        //FIND BY ID
        BlogCategoryApi.categoryApiFindById(parametersHandlingViewId.id)
            //BlogCategoryApi.categoryApiFindById(localStorage.getItem("register_view_id")) //2.YOL
            .then((response) => {
                console.log(response);
                // console.log(response.data);
                // console.log(response.status);
                // console.log(response.headers);
                if (response.status == 200) {
                    setblogCategoryViewState(response.data);
                }
            })
            .catch((err) => {
                console.error(err);
            });
    }, []); //end useEffect

    // RETURN
    return (
        <React.Fragment>

            <div className="w-full mt-12 text-center mb-12 max-w-sm bg-white border border-gray-200 rounded-lg shadow dark:bg-gray-800 dark:border-gray-700">
                <div className="flex justify-end px-4 pt-4">
                    <button
                        id="dropdownButton"
                        data-dropdown-toggle="dropdown"
                        className="inline-block text-gray-500 dark:text-gray-400 hover:bg-gray-100 dark:hover:bg-gray-700 focus:ring-4 focus:outline-none focus:ring-gray-200 dark:focus:ring-gray-700 rounded-lg text-sm p-1.5"
                        type="button"
                    > <span className="sr-only">Open dropdown</span>
                    </button>

                    {/* Dropdown menu */}
                    <div id="dropdown"
                        className="z-10 hidden text-base list-none bg-white divide-y divide-gray-100 rounded-lg shadow w-44 dark:bg-gray-700"
                    >
                        <ul className="py-2" aria-labelledby="dropdownButton">
                            <li>
                                <a  href="#"
                                    className="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 dark:hover:bg-gray-600 dark:text-gray-200 dark:hover:text-white"
                                >  Edit
                                </a>
                            </li>
                            <li>
                                <a
                                    href="#"
                                    className="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 dark:hover:bg-gray-600 dark:text-gray-200 dark:hover:text-white"
                                > Export Data
                                </a>
                            </li>
                            <li>
                                <a  href="#"
                                    className="block px-4 py-2 text-sm text-red-600 hover:bg-gray-100 dark:hover:bg-gray-600 dark:text-gray-200 dark:hover:text-white"
                                >  Delete
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>

                <div className="flex flex-col items-center pb-10">
                    <img
                        className="w-24 h-24 mb-3 rounded-full shadow-lg"
                        src={sunrise}
                        alt={blogCategoryViewState.categoryName}
                    />

                    <h5 className="mb-1 text-xl font-medium text-gray-900 dark:text-white">
                        {blogCategoryViewState.categoryId}
                    </h5>

                    <span className="text-sm text-gray-500 dark:text-gray-400">
                        {blogCategoryViewState.categoryName}
                    </span>

                    <div className="flex mt-4 md:mt-6">
                        <a  href="#"
                            className="inline-flex items-center px-4 py-2 text-sm font-medium text-center text-white bg-blue-700 rounded-lg hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800"
                        >Add friend
                        </a>
                        <a href="#"
                            className="inline-flex items-center px-4 py-2 text-sm font-medium text-center text-gray-900 bg-white border border-gray-300 rounded-lg hover:bg-gray-100 focus:ring-4 focus:outline-none focus:ring-gray-200 dark:bg-gray-800 dark:text-white dark:border-gray-600 dark:hover:bg-gray-700 dark:hover:border-gray-700 dark:focus:ring-gray-700 ms-3"
                        > Message
                        </a>
                    </div>
                </div>
            </div>
        </React.Fragment>
    )// end return
} //end RegisterView

// EXPORT
export default withTranslation()(BlogCategoryView)

