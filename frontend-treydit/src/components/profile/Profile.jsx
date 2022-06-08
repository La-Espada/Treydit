import React,{useEffect, useState} from 'react'
import {
  ChakraProvider,
  Flex,
  Image,
  Stack,
  Text,
  Box,
  Divider,
  IconButton
} from '@chakra-ui/react'
import { FaHome, FaShoppingBag, FaUser,FaBackward } from 'react-icons/fa';
import {Link} from 'react-router-dom';



function Profile(){
  const [username,setUsername] = useState();
   const [firstname,setFirstname] = useState();
   const [lastname, setLastname] = useState();
   const [phonenumber, setPhonenumber] = useState();
   const [email, setEmail] = useState();
   const [items, setItems] = useState();
 
 
 
    useEffect(()=>{
    
      fetch("http://localhost:8080/api/treyder/3")
      .then(response => response.json())
      .then(data => {
        setFirstname(data.firstname);
        setLastname(data.lastname);
        setUsername(data.username);
        setPhonenumber(data.phonenumber);
        setEmail(data.email);
        setItems(data.items);
      });
      console.log(items);
      
     
     /*console.log(data);
     setFirstname(data.firstname);
     console.log(firstname);
     setLastname(data.lastname);
     console.log(lastname);
     setUsername(data.username);
     console.log(username);
    },[]);
    */
   },[]);
   
   return(
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
           {username}
         </Text>
         <Divider borderColor="#ffffff" backgroundColor="#ffffff" />
         <Text color="#ffffff">{firstname}</Text>
         <Text color="#ffffff">{lastname}</Text>
         <Divider borderColor="#ffffff" />
         <Text color="#ffffff">{phonenumber}</Text>
         <Text color="#ffffff">{email}</Text>
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
       <Text m="1%">{username} 's collection</Text>
       <Flex m="1%" mt={0}>
         {items && items.map(item =>
         
           <Box
           height="250px"
           backgroundColor="#ffff"
           width="200px"
           borderRadius="5px">
             <Image  src={item.photo}/>
            <Box>
 
            </Box>
            <p>Name: {item.name}</p>
            <p>Price: {item.cost} €</p>
            <p>Condition: {item.condition}</p>
            
           </Box>
           )}
         
 
       </Flex>
     </Flex>
     <Flex
       height="15vh"
       backgroundColor="#000000"
       justifyContent="flex-end"
       alignItems="flex-end"
     >
 
       <Link to="/dashboard">
       <IconButton 
    
         icon={<FaBackward/>}
         size="lg"
         p={6}
         mb="60%"
         mr="3"
         
         />
       </Link>
       
    
     </Flex>
   </ChakraProvider>
   )
 }

export default Profile
