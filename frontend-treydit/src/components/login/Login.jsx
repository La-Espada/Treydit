import React,{useContext, useState} from 'react'
import {
  ChakraProvider,
  InputGroup,
  InputLeftAddon,
  InputRightElement,
  Icon,
  Container,
  Heading,
  Grid,
  Button,
  Input,
  Text
} from '@chakra-ui/react'
import { CopyIcon } from '@chakra-ui/icons'
import { useNavigate } from 'react-router-dom'
import { reverseMultiplyAndSum } from 'validator/lib/util/algorithms';

function Login() {
  const [user,setUser] = useState();
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  let navigate = useNavigate()

  async function login(){
    console.warn(email,password);
    let item = {email,password};
    let result = await fetch("http://localhost:8080/api/login",{
      method:'POST',
      headers:{
        "Content-Type":"application/json",
        "Accept":"application/json",
      },
      body:JSON.stringify(item)
    });
    if (result.ok) {
      navigate("/dashboard")
    }
    let json = await result.json();
    const string = JSON.stringify(json);
    console.log(json);
    console.log(string);
    setUser(JSON.parse(string));
    console.log(user);
    //setUser(result);
    localStorage.setItem("user",user);
    console.log(localStorage.getItem('user'));
  }
return(
  <ChakraProvider resetCSS>
    <Container
      textAlign="center"
      borderRadius={5}
      backgroundColor="#000000"
      p={0}
    >
      <Heading display="block" size="2xl" m={10} color="#ffffff" p={5}>
        Start trading.
      </Heading>
      <Container
        display="block"
        borderRadius={10}
        backgroundColor="#000000"
        color="#ffffff"
        p={10}
      >
        <InputGroup mb={5}>
          <InputLeftAddon backgroundColor="#000000" color="#ffffff">
            Email
          </InputLeftAddon>
          <InputRightElement>
            <CopyIcon name="email" />
          </InputRightElement>
          <Input
            name="Email"
            placeholder='email'
            onChange={(e)=> setEmail(e.target.value)}
            bgGradient="linear(to right, #ffffff,#aeaeae)"
            color="#000000"
          />
        </InputGroup>
        <InputGroup mb={5}>
          <InputLeftAddon backgroundColor="#000000" color="#ffffff">
            Password
          </InputLeftAddon>
          <InputRightElement>
            <CopyIcon name="password" />
          </InputRightElement>
          <Input
            name="Password"
            placeholder='password'
            onChange={(e)=> setPassword(e.target.value)}
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
          flexDirection="column"
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
            onClick={login}
          >
            Login
          </Button>
          <Text textAlign="left" display="inline-block">
            Don't have an account. Register <a onClick={()=>navigate('/register')}>here.</a>
          </Text>
        </Grid>
      </Container>
    </Container>
  </ChakraProvider>
)
}
export default Login
