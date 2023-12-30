// REACT
import React from 'react';
import ReactDOM from 'react-dom/client';

// ROUTER
// BrowserRouter => http://localhost:3000/
// HashRouter    => http://localhost:3000/#
import {BrowserRouter} from "react-router-dom";
import BlogRouter from "./BlogRouter";

// Index.CSS
import './index.css';
import reportWebVitals from './reportWebVitals';

// ROOT
const root = ReactDOM.createRoot(document.getElementById('root'));

// RENDER
root.render(
    <React.StrictMode>
        <BrowserRouter>
            <BlogRouter/>
        </BrowserRouter>
    </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
