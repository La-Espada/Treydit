import React from 'react'
import { ChakraProvider, Flex, IconButton, Image, Text } from '@chakra-ui/react'
import { Search2Icon, SettingsIcon, CopyIcon } from '@chakra-ui/icons'
import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';
import Dashboard from "./components/dashboard/dashboard"
import Profile from "./components/profile/Profile"
import Register from "./components/register/Register"
import Login from "./components/login/Login"
import Add from "./components/add/Addit"
import Offer from "./components/offer/Offer"
import AcceptOffer from "./components/acceptoffer/AcceptOffer"


const App = () => (

         <BrowserRouter>
         <Routes>
          <Route path="/dashboard" element={<Dashboard />}></Route>
          <Route path="/profile" element={<Profile />}></Route>
          <Route path="/register" element={<Register />}></Route>
          <Route path="/login" element={<Login />}></Route>
          <Route path="/add" element={<Add />}></Route>
          <Route path="/offer" element={<Offer />}></Route>
          <Route path="/acceptoffer" element={<AcceptOffer />}></Route>
         </Routes>
         </BrowserRouter>   

   )



export default App;
