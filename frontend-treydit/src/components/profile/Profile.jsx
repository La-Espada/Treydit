import React from 'react'
import {
  ChakraProvider,
  Flex,
  Image,
  Stack,
  Text,
  Box,
  Divider
} from '@chakra-ui/react'

const Profile = () => (
  <ChakraProvider resetCSS>
    <Flex
      width="100%"
      height="35vh"
      display="flex"
      color="#000000"
      backgroundColor="#000000"
      justifyContent="flex-start"
      alignItems="center"
    >
      <Image
        height="150px"
        width="150px"
        src="https://cdn-1.debijenkorf.at/web_detail/balenciaga-speed-3-0-sneaker-mit-logo/?reference=034/750/13_0347507002125400_pro_flt_frt_01_1108_1528_5820517.jpg"
        objectFit="cover"
        borderRadius="10px"
        m="2%"
      />
      <Stack spacing={2} m="2%">
        <Text color="#ffffff" fontWeight="bold" fontSize="lg">
          username
        </Text>
        <Divider borderColor="#ffffff" backgroundColor="#ffffff" />
        <Text color="#ffffff">bio</Text>
        <Text color="#ffffff">lorem ipsum</Text>
        <Divider borderColor="#ffffff" />
        <Text color="#ffffff">reputation</Text>
        <Box
          height="20px"
          width="200px"
          color="#ffffff"
          backgroundColor="#ffffff"
        />
      </Stack>
    </Flex>
    <Flex
      height="50vh"
      color="#000000"
      backgroundColor="#ffffff"
      flexDirection="column"
      width="100%"
      justifyContent="center"
    >
      <Text m="1%">username's collection.</Text>
      <Flex m="1%" mt={0}>
        <Box
          height="250px"
          backgroundColor="#000000"
          width="200px"
          borderRadius="5px"
        />
      </Flex>
    </Flex>
    <Flex
      height="15vh"
      backgroundColor="#000000"
      justifyContent="flex-end"
      alignItems="flex-end"
    >
      <Text color="#ffffff" textAlign="justify" m="1%">
        back to home.
      </Text>
    </Flex>
  </ChakraProvider>
)

export default Profile
