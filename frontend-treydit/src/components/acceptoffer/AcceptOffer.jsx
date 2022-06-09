import React,{useEffect, useState} from 'react'
import {
  ChakraProvider,
  Flex,
  IconButton,
  Image,
  Text,
  Button,
  Avatar,
  Container,
  Heading,
  Grid,
  Box,
  Icon,
  Wrap
} from '@chakra-ui/react'
import { search, settings, copy, ArrowUpDownIcon, o } from '@chakra-ui/icons'
import { FaHome, FaShoppingBag, FaUser,FaBackward } from 'react-icons/fa';
import {Link, useNavigate} from 'react-router-dom'

function Offer(){

  const navigate = useNavigate();
  const [username,setUsername] = useState();
   const [firstname,setFirstname] = useState();
   const [lastname, setLastname] = useState();
   const [phonenumber, setPhonenumber] = useState();
   const [email, setEmail] = useState();
   const [items, setItems] = useState();
  const user = JSON.parse(localStorage.getItem('user'));
 
  console.log(user); 

   
   /*const [username2,setUsername2] = useState();
    const [firstname2,setFirstname2] = useState();
    const [lastname2, setLastname2] = useState();
    const [phonenumber2, setPhonenumber2] = useState();
    const [email2, setEmail2] = useState();
    const [items2, setItems2] = useState();

    */
    const [treyderList,setTreyderList] = useState();
 
 

    async function getTreyderOffer(){

    }

    useEffect(()=>{
    
      fetch("http://localhost:8080/api/treyder/" + user.id)
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

      const json =null;
},[]);


async function chooseTreyder(){
  let response = await fetch("http://localhost:8080/api/treyder",{
    method:'GET',
    headers:{
      "Content-Type":"application/json",
      "Accept":"application/json",
    },

  });
 
  const json = await response.json();
  const string = JSON.stringify(json);
  setTreyderList(JSON.parse(string));
  console.log("hal")
  console.log(treyderList);
}


    
     /*console.log(data);
     setFirstname(data.firstname);
     console.log(firstname);
     setLastname(data.lastname);
     console.log(lastname);
     setUsername(data.username);
     console.log(username);
    },[]);
    */
   
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
        width="100%"
        height="100%"
        ml="1%"
        justifyContent="flex-start"
        alignItems="center"
        backgroundColor="#ffffff"
        bgGradient="linear(to bottom right, #000000,#302f2f)"
        overflow="visible"
        flexDirection="row"
      >
        <Flex
         ml="20%"
        >
          <Wrap>
          <Container borderRadius={10}>
            <Heading color="#ffffff">Your Inventory</Heading>
            <Text color="#ffffff">you have...</Text>
            <Grid
              templateColumns="repeat(3, 1fr)"
              gap={3}
              display="grid"
              overflow="visible"
              backgroundColor="#0d0d0d"
              borderRadius={10}
            >
           {items && items.map(item =>
            <Button
            height= "250px"
            width ="200px">
              <Box>
              <Image src={item.photo}/>
              <p>Name: {item.name}</p>
            <p>Price: {item.cost} €</p>
            <p>Condition: {item.condition}</p>
            </Box>
            </Button>
            
            )}
            
              
            </Grid>
          </Container>

          <Container borderRadius={10}>
          <Heading color="#ffffff">Your Inventory</Heading>
            <Text color="#ffffff">you have...</Text>
            <Grid
              templateColumns="repeat(3, 1fr)"
              gap={3}
              display="grid"
              overflow="visible"
              backgroundColor="#0d0d0d"
              borderRadius={10}
            >
           {items && items.map(item =>
            <Button
            height= "250px"
            width ="200px">
              <Box>
              <Image src={item.photo}/>
              <p>Name: {item.name}</p>
            <p>Price: {item.cost} €</p>
            <p>Condition: {item.condition}</p>
            </Box>
            </Button>
            
            )}
            
              
            </Grid>
          </Container>
          </Wrap>
        </Flex>
        <Container overflow=" visible" display="block">
          <Container mb="5%">
            <Heading color="#ffffff" mb="">{username}</Heading>
            <Text color="#ffffff">you offer...</Text>
            <Flex
              overflow="visible"
              backgroundColor="#0d0d0d"
              borderRadius={10}
            >
              <Image
                 height="100px"
                 width="100px"
                 display="flex"
                 alt="item"
                 ml="38%"
                 padding="1%"
                
                 overflow="hidden"
                 fallbackSrc="https://static.vecteezy.com/system/resources/previews/000/349/672/original/camera-vector-icon.jpg"
              />
            </Flex>
          </Container>
          <Flex
            mr="2%"
            flexDirection="row"
            alignItems="center"
            justifyContent="space-around"
            display="flex"
            backgroundColor="#ffffff"
            borderRadius={10}
            bgGradient="linear(to bottom right, #f3f3f3,#bababa)"
          >
            <Button
              variant="solid"
              size="lg"
              mt={1}
              bgGradient="linear(to bottom right, green.200,blue.500)"
              borderRadius={10}
            >
              make offer
            </Button>
            <Button
              variant="solid"
              size="lg"
              mt={1}
              bgGradient="linear(to bottom right, green.200,blue.500)"
              borderRadius={10}
              onClick={chooseTreyder}
            >
              choose Treyder
            </Button>
            <ArrowUpDownIcon boxSize={20} display="block" m="2%" />
            <o />
          </Flex>
          <Container mt="5%">
            <Heading color="#ffffff" mb="1%">Username 2</Heading>
            <Text color="#ffffff">you receive...</Text>
            <Flex
              overflow="visible"
              backgroundColor="#0d0d0d"
              borderRadius={10}
            
            >
              <Image
                height="100px"
                width="100px"
                display="flex"
                alt="item"
                ml="38%"
                padding="1%"
               
                overflow="hidden"
                fallbackSrc="https://static.vecteezy.com/system/resources/previews/000/349/672/original/camera-vector-icon.jpg"
              />
             
       
            </Flex>
          </Container>
        </Container>
      </Flex>
    </Flex>
  </ChakraProvider>
)
}
export default Offer
