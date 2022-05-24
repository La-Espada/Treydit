import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import Register from './components/register/Register';
import { ChakraProvider } from '@chakra-ui/react';
import Dashboard from './components/dashboard/dashboard';
import LandingPage from './components/landingPage/LandingPage';


ReactDOM.render(
  <React.StrictMode>
  <ChakraProvider>
    <App/>
  </ChakraProvider>
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
