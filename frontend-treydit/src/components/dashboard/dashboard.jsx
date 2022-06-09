import React, { useEffect, useState} from 'react'
import { ChakraProvider, Flex, IconButton, Image, Text, Box } from '@chakra-ui/react'
import { Search2Icon, SettingsIcon, CopyIcon } from '@chakra-ui/icons'
import { FaHome, FaShoppingBag, FaUser,FaBackward } from 'react-icons/fa';
import {Link, useNavigate} from 'react-router-dom';


function Dashboard(){

const navigate = useNavigate();

const [items, setItems] = useState();

  
useEffect(()=>{
  
  fetch("http://localhost:8080/api/item")
  .then(response => response.json())
  .then(data =>{
        setItems(data)
  });
})

 return(
  <ChakraProvider resetCSS>
  <Flex width="100vw" height="100vh">
    <Flex
      flexDirection="column"
      justifyContent="flex-start"
      alignItems="stretch"
      display="flex"
      ml="0%"
      mr="0%"
      mb="0%"
      mt="0%"
      height="100%"
      backgroundColor="black"
    >
      
      <Flex flexDirection="column">
      <Link to="/landing">
        <IconButton
          aria-label="icon"
          icon={<FaHome />}
          size="lg"
          colorScheme="black"
          display="block"
          p={5}
          mt="5%"
        />
         </Link>

         <Link to="/dashboard">
        <IconButton
          aria-label="icon"
          icon={<FaShoppingBag />}
          size="lg"
          colorScheme="black"
          p={5}
          mt="5%"
        />
        </Link>
      </Flex>
     

      
      <Flex flexDirection="column" mt="1300%">
        <Image height={0.4} width="80%" backgroundColor="grey" ml="11%" />
        <Link to="/profile">
        <IconButton
          aria-label="icon"
          icon={<FaUser />}
          size="lg"
          colorScheme="black"
          p={5}
          mt="5%"
        />
         </Link>
        <IconButton
          aria-label="icon"
          icon={<FaBackward />}
          size="lg"
          colorScheme="black"
          p={5}
          mt="5%"
          onClick={() => navigate(-1)}
        />
      </Flex>
     
    </Flex>
    <Flex
      ml="1%"
      width="100%"
      justifyContent="flex-start"
      flexDirection="column"
    >
      <Flex flexDirection="column">
        <Text fontWeight="bold" fontSize="7xl">
          welcome
        </Text>
        <Text fontWeight="bold" fontSize="7xl">
          back.
        </Text>
      </Flex>
      <Image height={1} width="30%" backgroundColor="black" />
      <Flex flexDirection="column">
        <Text fontWeight="bold" fontSize="4xl">
          recently viewed
        </Text>
        <Flex p='6'>
       {items && items.map(item =>
        <Box
        height="250px"
        backgroundColor="grey"
        width="200px"
          borderRadius="5px">
        <Image  src= {item.photo}/>
        <Box>
        </Box>
        <p>Name: {item.name}</p>
        <p>Price: {item.cost} €</p>
        <p>Condition: {item.condition}</p>

</Box>
)}

       </Flex>
      </Flex>
    
      
      
    </Flex>
  </Flex>
</ChakraProvider>

 ) 
}

export default Dashboard