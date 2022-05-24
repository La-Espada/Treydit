import React from 'react'
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

function Login() {
  let navigate = useNavigate()
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
            bgGradient="linear(to right, #ffffff,#aeaeae)"
            color="#000000"
          />
        </InputGroup>
        <InputGroup mb={5}>
          <InputLeftAddon backgroundColor="#000000" color="#ffffff">
            Password
          </InputLeftAddon>
          <InputRightElement>
            <CopyIcon name="email" />
          </InputRightElement>
          <Input
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
            onClick={()=>navigate('/dashboard')}
          >
            Login
          </Button>
          <Text textAlign="left" display="inline-block">
            Don't have an account. Register here.
          </Text>
        </Grid>
      </Container>
    </Container>
  </ChakraProvider>
)
}
export default Login
