import React from 'react'
import { ChakraProvider, Flex, IconButton, Image, Text } from '@chakra-ui/react'
import { Search2Icon, SettingsIcon, CopyIcon } from '@chakra-ui/icons'
import { Router, Routes, Route, Navigate, BrowserRouter, } from 'react-router-dom';
import Dashboard from "./components/dashboard/dashboard"
import Profile from "./components/profile/Profile"
import Register from "./components/register/Register"
import Login from "./components/login/Login"
import Add from "./components/add/Addit"
import Offer from "./components/offer/Offer"
import AcceptOffer from "./components/acceptoffer/AcceptOffer"
import Landing from './components/landingPage/LandingPage';


function App(){
      return(
      
           <BrowserRouter>
            <Routes>
            <Route exact path="/" element={<Landing/>}/>
             <Route exact path="/dashboard" element={<Dashboard/>}/>
             <Route exact path="/profile" element={<Profile/>}/>
             <Route exact path="/register" element={<Register/>}/>
             <Route exact path="/login" element={<Login/>}/>
             <Route exact path="/add" element={<Add/>}/>
             <Route exact path="/offer" element={<Offer/>}/>
             <Route exact path="/acceptoffer" element={<AcceptOffer/>}/>
            </Routes>
            </BrowserRouter>   
   );
}

export default App;
