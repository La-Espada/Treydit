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
import { useNavigate } from 'react-router-dom';
import axios from 'axios';


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

export default class Register extends Component{ 
  constructor(props){
    super(props)
    this.handleRegister = this.handleRegister.bind(this);
    this.onChangeUsername = this.onChangeUsername.bind(this);
    this.onChangeEmail = this.onChangeEmail.bind(this);
    this.onChangeFirstname = this.onChangeFirstname.bind(this);
    this.onChangeLastname = this.onChangeLastname.bind(this);
    this.onChangeGender = this.onChangeGender.bind(this);
    this.onChangePhonenumber = this.onChangePhonenumber.bind(this);
    this.onChangePassword = this.onChangePassword.bind(this);
    this.navigate = this.useNavigate.bind(this);
    this.state ={
      username: "",
      email: "",
      firstname: "",
      lastname: "",
      gender:"",
      phonenumber: "",
      password: "",
      successful: false,
      message: ""
    };
  }

  
  

  useNavigate(){
    
  }
     onChangeUsername = (e) => {
      this.setState({
        username:e.target.value
    });
  }
     onChangeEmail = (e) => {
      this.setState({
        email:e.target.value
    });
  }
     onChangePassword = (e) => {
      this.setState({
        password:e.target.value
    });
  }
     onChangeFirstname = (e) => {
      this.setState({
        firstname:e.target.value
    });
  }
     onChangeLastname = (e) => {
      this.setState({
        lastname:e.target.value
    });
  }
     onChangeGender = (e) => {
      this.setState({
        gender:e.target.value
    });
  }
     onChangePhonenumber = (e) => {
      this.setState({
        phonenumber:e.target.value
    });
  }

  handleRegister(e){ 
    //e.preventDefault();
    this.setState({
      message:"",
      successful: false
    });
    //this.validateAll();
    //if(this.checkBtn.context._error.length === 0){
      AuthService.register(
        this.state.username,
        this.state.firstname,
        this.state.lastname,
        this.state.email,
        this.state.gender,
        this.state.phonenumber,
        this.state.password
      ).then(
        response => {
          this.setState({
            message: response.data.message,
            successful: true
          });
        },
        error =>{
          const resMessage = (error.response &&
                                error.response.data &&
                                error.response.data.message) ||
                                error.message || 
                                error.toString();
                                this.setState({
                                  message: resMessage,
                                  successful: false
            });
          }
        );
    
  }
  render(){
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
      onSubmit={this.handleRegister} ref={c => {this.form = c }}
    >
   
      <><InputGroup mb={5}>
          <InputLeftAddon backgroundColor="#000000" color="#ffffff">
            Username
          </InputLeftAddon>
          <Input
            name="username"
            value={this.state.username}
            onChange={this.onChangeUsername}
            validations={[required, vusername]}
            bgGradient="linear(to right, #fdfdfd,#aeaeae)"
            color="#000000" />
          <InputLeftAddon backgroundColor="#000000" color="#ffffff">
            First name
          </InputLeftAddon>
          <Input
            name="Firstname"
            value={this.state.firstname}
            onChange={this.onChangeFirstname}
            validations={[required, vfirstname]}
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
              value={this.state.lastname}
              onChange={this.onChangeLastname}
              validations={[required, vlastname]}
              bgGradient="linear(to right, #ffffff,#aeaeae)"
              color="#000000" />
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
              value={this.state.email}
              onChange={this.onChangeEmail}
              validations={[required, validEmail]}
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
              value={this.state.phonenumber}
              onChange={this.onChangePhonenumber}
              validations={[required, vphonenumber]}
              bgGradient="linear(to right, #ffffff,#aeaeae)"
              color="#000000" />
          </InputGroup><Stack spacing={2} mb={5}>
            <Text textAlign="center" display="flex" fontWeight="bold">
              Gender
            </Text>
            <Select
              name="Gender"
              value={this.state.gender}
              onChange={this.onChangeGender}
              icon={<ChevronDownIcon />}
              variant="outline"
              size="md"
              backgroundColor="#ffffff"
              color="#000000"
              bgGradient="linear(to right, #ffffff,#aeaeae)" />
          </Stack><InputGroup mb={5}>
            <InputLeftAddon backgroundColor="#000000" color="#ffffff">
              Password
            </InputLeftAddon>
            <InputRightElement>
              <CopyIcon name="email" />
            </InputRightElement>
            <Input
              name="Password"
              value={this.state.password}
              onChange={this.onChangePassword}
              validations={[required, vpassword]}
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
              onClick={()=> {this.handleRegister()}}
              //onClick={() => navigate('/login')}
            >
              Save
            </Button>
          </Grid></>
      {this.state.message && (
        <div className="form-group">
        <div
          className={
            this.state.successful
              ? "alert alert-success"
              : "alert alert-danger"
          }
          role="alert"
        >
          {this.state.message}
        </div>
      </div>
      )}
       
    </Container>
  </Container>
    );
  }
}





    