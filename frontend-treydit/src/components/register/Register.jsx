import React, { Component, useRef, useState } from 'react'
import Form from "react-validation/build/form";
import { isEmail } from "validator";
import AuthService from "../../services/auth.service";
import {
  Input,
  InputGroup,
  InputLeftAddon,
  InputRightElement,
 Container,
  Heading,
  Stack,
  Select,
  Text,
  Grid,
  Button
} from '@chakra-ui/react'
import { CopyIcon, ChevronDownIcon } from '@chakra-ui/icons'
import { useNavigate, useHistory } from 'react-router-dom';
import axios from 'axios';
import { render } from 'react-dom';



function Register(){
  const [username, setUsername] = useState("");
  const [firstname, setFirstname]=useState("");
  const [lastname, setLastname] = useState("");
  const [email, setEmail] = useState("");
  const [phonenumber, setPhonenumber]= useState("");
  const [gender, setGender] = useState("");
  const [password, setPassword] = useState("");

  let navigate = useNavigate();

 

  async function register(){
    console.warn(username,firstname,lastname,email,phonenumber,gender,password);
    let item = {username,firstname,lastname,email,phonenumber,gender,password};
    let result = await fetch("http://localhost:8080/api/register",{
      method:'POST',
      headers:{
        "Content-Type":"application/json",
        "Accept":"application/json",
      },
      body:JSON.stringify(item)
    }).then(response => {
      if(response.ok){
        navigate("/login")
      }
      throw new Error("Something went wrong...")
    });
    result = await result.json();
    localStorage.setItem("user-info",JSON.stringify(result))
  }


return (
<Container
    textAlign="center"
    borderRadius={5}
    backgroundColor="#000000"
    p={0}
   
  >
    <Heading display="block" size="2xl" m={10} color="#ffffff" p={5}>
      Become a Treydr.
    </Heading>
    <Container
      display="block"
      borderRadius={10}
      backgroundColor="#000000"
      color="#ffffff"
       
    >

      <><InputGroup mb={5}>
          <InputLeftAddon backgroundColor="#000000" color="#ffffff">
            Username
          </InputLeftAddon>
          <Input
            name="username"
            placeholder='Username'
            onChange={(e)=> setUsername(e.target.value)}
            bgGradient="linear(to right, #fdfdfd,#aeaeae)"
            color="#000000" />
          <InputLeftAddon backgroundColor="#000000" color="#ffffff">
            First name
          </InputLeftAddon>
          <Input
            name="Firstname"
            onChange={(e)=> setFirstname(e.target.value)}
            placeholder="Firstname"
            bgGradient="linear(to right, #fdfdfd,#aeaeae)"
            color="#000000" />
          <InputRightElement>
            <CopyIcon name="email" color="#ffffff" />
          </InputRightElement>

        </InputGroup><InputGroup mb={5}>
            <InputLeftAddon color="#ffffff" backgroundColor="#000000">
              Last name
            </InputLeftAddon>
            <Input
              name="Lastname"
              onChange={(e)=> setLastname(e.target.value)}
              bgGradient="linear(to right, #ffffff,#aeaeae)"
              color="#000000"/>
            <InputRightElement>
              <CopyIcon name="email" />
            </InputRightElement>

          </InputGroup><InputGroup mb={5}>
            <InputLeftAddon backgroundColor="#000000" color="#ffffff">
              Email
            </InputLeftAddon>
            <InputRightElement>
              <CopyIcon name="email" />
            </InputRightElement>
            <Input
              name="Email"
              onChange={(e)=> setEmail(e.target.value)}
              bgGradient="linear(to right, #ffffff,#aeaeae)"
              color="#000000" />

          </InputGroup><InputGroup mb={5}>
            <InputLeftAddon backgroundColor="#000000" color="#ffffff">
              Phone number
            </InputLeftAddon>
            <InputRightElement>
              <CopyIcon name="email" />
            </InputRightElement>
            <Input
              name="Phonenumber"
              onChange={(e)=>setPhonenumber(e.target.value)}
              bgGradient="linear(to right, #ffffff,#aeaeae)"
              color="#000000" />

          </InputGroup><Stack spacing={2} mb={5}>
            <Text textAlign="center" display="flex" fontWeight="bold">
              Gender
            </Text>
            <Select
              name="Gender"
              onChange={(e)=> setGender(e.target.value)}
              icon={<ChevronDownIcon />}
              variant="outline"
              size="md"
              backgroundColor="#ffffff"
              color="#000000"
              bgGradient="linear(to right, #ffffff,#aeaeae)">
                <option value={"MALE"}>MALE</option>
                <option value={"FEMALE"}>FEMALE</option>
                <option value={"Divers"}>DIVERS</option>

                </Select>
          </Stack><InputGroup mb={5}>
            <InputLeftAddon backgroundColor="#000000" color="#ffffff">
              Password
            </InputLeftAddon>
            <InputRightElement>
              <CopyIcon name="email" />
            </InputRightElement>
            <Input
              name="Password"
              onChange={(e)=> setPassword(e.target.value)}
              bgGradient="linear(to right, #ffffff,#aeaeae)"
              color="#000000" />
          </InputGroup><Grid
            templateColumns="repeat(5, 1fr)"
            gap={6}
            textAlign="left"
            row={6}
            display="flex"
            flexDirection="row-reverse"
            mb={5}
            pb={10}
            pt={10}
          >
            <Button
              variant="solid"
              size="md"
              textAlign="left"
              display="flex"
              borderRadius={8}
              backgroundColor="#028aff"
              color="#ffffff"
              onClick={register}
              //onClick={() => navigate('/login')}
            >
              Save
            </Button>
          </Grid></>

    </Container>
  </Container>
    );
}
export default Register;






    