import React, { useRef, useState } from 'react'
import Form from "react-validation/build/form";
import Input from "react-validation/build/input";
import CheckButton from "react-validation/build/button";
import { isEmail } from "validator";
import AuthService from "../services/auth.service";
import {
  ChakraProvider,
  InputGroup,
  InputLeftAddon,
  InputRightElement,
  Icon,
  Container,
  Heading,
  Stack,
  Select,
  Text,
  Grid,
  Button
} from '@chakra-ui/react'
import { CopyIcon, ChevronDownIcon } from '@chakra-ui/icons'


const required = (value) =>{
    if(!value){
        <div className='invalid-feedback d-block'>
            This field is required!
        </div>
    }
};
const validEmail = (value) => {
    if (!isEmail(value)) {
      return (
        <div className="invalid-feedback d-block">
          This is not a valid email.
        </div>
      );
    }
  };
  const vusername = (value) => {
    if (value.length < 3 || value.length > 20) {
      return (
        <div className="invalid-feedback d-block">
          The username must be between 3 and 20 characters.
        </div>
      );
    }
  };
  const vpassword = (value) => {
    if (value.length < 6 || value.length > 40) {
      return (
        <div className="invalid-feedback d-block">
          The password must be between 6 and 40 characters.
        </div>
      );
    }
  };
  const vfirstname = (value) => {
    if (value.length < 3 || value.length > 20) {
      return (
        <div className="invalid-feedback d-block">
          The Firstname must be filled.
        </div>
      );
    }
  };
  const vlastname = (value) => {
    if (value.length < 3 || value.length > 20) {
      return (
        <div className="invalid-feedback d-block">
          The Lastname must be filled.
        </div>
      );
    }
  };
  const vphonenumber = (value) => {
    if (value.length < 3 || value.length > 20) {
      return (
        <div className="invalid-feedback d-block">
          The Phonenumber must be filled.
        </div>
      );
    }
  };
const Register = (props) =>{ 
    const form = useRef();
    const checkBtn = useRef();
    const [username, setUsername] =useState("");
    const[email,setEmail] = useState("");
    const[password, setPassword] = useState("");
    const[firstname, setFirstname] = useState("");
    const[lastname, setLastname] = useState("");
    const[gender,setGender] = useState("");
    const[phonenumber, setPhonenumber] =useState("");
    const [successful, setSuccessful] = useState(false);
    const [message, setMessage] = useState("");
    const onChangeUsername = (e) => {
        const username = e.target.value;
        setUsername(username);
      };
      const onChangeEmail = (e) => {
        const email = e.target.value;
        setEmail(email);
      };
      const onChangePassword = (e) => {
        const password = e.target.value;
        setPassword(password);
      };
      const onChangeFirstname = (e) => {
        const firstname = e.target.value;
        setFirstname(firstname);
      };
      const onChangeLastname = (e) => {
        const lastname = e.target.value;
        setLastname(lastname);
      };
      const onChangeGender = (e) => {
        const gender = e.target.value;
        setGender(gender);
      };
      const onChangePhonenumber = (e) => {
        const phonenumber = e.target.value;
        setPhonenumber(phonenumber);
      };
const handleRegister = (e) =>{
    e.preventDefault();
    setMessage("");
    setSuccessful(false);
    form.current.validateAll();
    if(checkBtn.current.context._error.length == 0){
        AuthService.register(username,email,password,firstname,lastname,gender,phonenumber).then(
            (response) => {
                setMessage(response.data.message);
                setSuccessful(true);
            },
            (error) =>{
                const resMessage = (error.response && error.response.data && error.response.data.message) || error.message || error.toString();
                setMessage(resMessage);
                setSuccessful(false);
            }
        );
    }
};

return (
  <ChakraProvider resetCSS>
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
        <InputGroup onSubmit={handleRegister} ref={form} mb={5}>
          <InputLeftAddon backgroundColor="#000000" color="#ffffff">
            First name
          </InputLeftAddon>
          <Input
          name="Firstname"
          value={firstname}
          onChange={onChangeFirstname}
          validations = {[required,vfirstname]}
          bgGradient="linear(to right, #fdfdfd,#aeaeae)"
          color="#000000"
          />
          <InputRightElement>
            <CopyIcon name="email" color="#ffffff" />
          </InputRightElement>
        </InputGroup>
        <InputGroup mb={5}>
          <InputLeftAddon color="#ffffff" backgroundColor="#000000">
            Last name
          </InputLeftAddon>
          <Input
          name="Lastname"
          value={lastname}
          onChange={onChangeLastname}
          validations = {[required,vlastname]}
            bgGradient="linear(to right, #ffffff,#aeaeae)"
            color="#000000"
          />
          <InputRightElement>
            <CopyIcon name="email" />
          </InputRightElement>
        </InputGroup>
        <InputGroup mb={5}>
          <InputLeftAddon backgroundColor="#000000" color="#ffffff">
            Email
          </InputLeftAddon>
          <InputRightElement>
            <CopyIcon name="email" />
          </InputRightElement>
          <Input
          name="Email"
          value={email}
          onChange={onChangeEmail}
          validations = {[required,validEmail]}
            bgGradient="linear(to right, #ffffff,#aeaeae)"
            color="#000000"
          />
        </InputGroup>
        <InputGroup mb={5}>
          <InputLeftAddon backgroundColor="#000000" color="#ffffff">
            Phone number
          </InputLeftAddon>
          <InputRightElement>
            <CopyIcon name="email" />
          </InputRightElement>
          <Input
          name="Phonenumber"
          value={phonenumber}
          onChange={onChangePhonenumber}
          validations = {[required,vphonenumber]}
            bgGradient="linear(to right, #ffffff,#aeaeae)"
            color="#000000"
          />
        </InputGroup>
        <Stack spacing={2} mb={5}>
          <Text textAlign="center" display="flex" fontWeight="bold">
            Gender
          </Text>
          <Select
          name="Gender"
          value={gender}
          onChange={onChangeGender}
            icon={<ChevronDownIcon />}
            variant="outline"
            size="md"
            backgroundColor="#ffffff"
            color="#000000"
            bgGradient="linear(to right, #ffffff,#aeaeae)"
          />
        </Stack>
        <InputGroup mb={5}>
          <InputLeftAddon backgroundColor="#000000" color="#ffffff">
            Password
          </InputLeftAddon>
          <InputRightElement>
            <CopyIcon name="email" />
          </InputRightElement>
          <Input
          name="Password"
          value={password}
          onChange={onChangePassword}
          validations = {[required,vpassword]}
            bgGradient="linear(to right, #ffffff,#aeaeae)"
            color="#000000"
          />
        </InputGroup>
        <Grid
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
          >
            Save
          </Button>
        </Grid>
      </Container>
    </Container>
  </ChakraProvider>
)
};

export default Register;
