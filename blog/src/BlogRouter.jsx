// rfce

// REACT
import React from 'react'

// I18N
import { withTranslation } from 'react-i18next'

// HEADER,MAIN,FOOTER
import BlogHeader from './components/BlogHeader'
import BlogFooter from './components/BlogFooter'
import BlogMain from './components/BlogMain'

// ROUTER
import { Navigate, Route, Routes } from 'react-router-dom'

// FUNCTION BlogRouter
function BlogRouter() {

    //RETURN
    return (
        <React.Fragment>
            {/* Blog Header */}
            <BlogHeader logo="fa-solid fa-road-barrier"></BlogHeader>

            {/* Blog Main */}
            <div className="container">
                <Routes>
                    {/* Root Path */}
                    <Route path={"/"} element={<BlogMain/>} />
                    <Route path={"/index"} element={<BlogMain/>} />

                    {/* Blog Category */}
                    {/* Blog */}
                    {/* Register */}
                    {/* Login */}
                    {/* Email */}
                    {/* Rol */}

                    {/* Bad Request */}
                    {/* <Route path={"*"} element={<h1>404</h1>} /> */}
                    <Route path={"*"} element={<Navigate to={"/"}/>}/>
                </Routes>
            </div>  {/*  Main */}

            {/* Blog Footer */}
            <BlogFooter copy="&copy; Bütün Haklar Saklıdır."></BlogFooter>
        </React.Fragment>
    ) //end Return
} //end BlogRouter

// I18N
// EXPORT (BlogRouter)
export default withTranslation()(BlogRouter) 
