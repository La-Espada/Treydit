import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter } from "react-router-dom";
import './index.css';
import App from './App';
import Register from './components/Register';
import reportWebVitals from './reportWebVitals';
ReactDOM.render(
  <BrowserRouter>
   <Register/>
  </BrowserRouter>,
  document.getElementById('root')
);
reportWebVitals();