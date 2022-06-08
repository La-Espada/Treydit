import React,{useState} from 'react'
import { useNavigate, useHistory } from 'react-router-dom';

import {
  ChakraProvider,
  Container,
  Heading,
  Grid,
  Button,
  FormControl,
  FormLabel,
  Input,
  FormHelperText,
  FormErrorMessage,
  Textarea,
  Divider,
  Image,
  Text,
  Select,
  Stack,
  IconButton,
  SimpleGrid
} from '@chakra-ui/react'
import { CopyIcon, ChevronDownIcon } from '@chakra-ui/icons'

import { AddIcon } from '@chakra-ui/icons'

function Addit(){
  const [name, setName] = useState();
  const [description, setDescription] = useState();
  const [cost, setCost] = useState();
  const [image, setImage] = useState();
  const [condition, setCondition] = useState();
  const [category, setCategory] = useState();
  const [treyderId,setTreyderId] = useState();


  const onImageChange = (event) => {
    if (event.target.files && event.target.files[0]) {
      setImage(URL.createObjectURL(event.target.files[0]));
    }
   }
  const onSourceChange = (e) =>{
    showImageThumbnail(this);

  }
  function showImageThumbnail(fileInput){

  }


  let navigate = useNavigate();




  async function addit(){
    console.warn(name,description,cost,condition,category,treyderId,image);
    let item = {name,description,cost,condition,category,treyderId,image};
    let result = await fetch("http://localhost:8080/api/3/addItem",{
      method:'POST',
      headers:{
        "Content-Type":"application/json",
        "Accept":"application/json",
      },
      body:JSON.stringify(item)
    }).then(response => {
      if(response.ok){
        navigate("/dashboard")
      }
    })
  }

  async function addImage(file){
    let formData = new FormData();
    formData.append("file",file);
    return await fetch("http://localhost:8080/api/3/")
    
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
        add it.
      </Heading>
      <Container
        display="block"
        borderRadius={10}
        backgroundColor="#000000"
        color="#ffffff"
        p={10}
      >
        <Grid
          templateColumns="repeat(5, 1fr)"
          textAlign="left"
          row={6}
          display="flex"
          flexDirection="column"
          mb={5}
          pb={10}
          pt={10}
        >
          <FormControl mb={5}>
            <FormLabel>Image</FormLabel>
            <FormErrorMessage>Error message</FormErrorMessage>
            <Image
              height="100px"
              width="100px"
              src={image}
              backgroundColor="#ffffff"
            />
            <Input onChange={(e)=>setImage(e.target.value)}/>
            
            <IconButton
              aria-label="icon"
              type='file'

              name="fileImage"
              id="fileimage"
              icon={<AddIcon />}
              size="md"
              mt={2}
              colorScheme="blackAlpha"
              backgroundColor="#9b9b9b"
              bgGradient="linear(to bottom right, whiteAlpha.500,blackAlpha.500)"
            />
            <FormHelperText>Add an image.</FormHelperText>
          </FormControl>
          <FormControl mb={5} isRequired>
            <FormLabel>Item name</FormLabel>
            <Input onChange={(e)=>setName(e.target.value)} />
            <FormHelperText>Add the name of your item.</FormHelperText>
            <FormErrorMessage>Error message</FormErrorMessage>
          </FormControl>
          <FormControl mb={5} isRequired>
            <FormLabel>Item cost</FormLabel>
            <Input onChange={(e) => setCost(e.target.value)}/>
            <FormHelperText>Add the cost of your item.</FormHelperText>
            <FormErrorMessage>Error message</FormErrorMessage>
          </FormControl>
          <FormControl mb={5}>
            <FormLabel>Description</FormLabel>
            <Textarea onChange={(e)=> setDescription(e.target.value)} />
            <FormHelperText>Add a description.</FormHelperText>
            <FormErrorMessage>Error message</FormErrorMessage>
          </FormControl>
          <Stack spacing={2} mb={5}>
            <Text textAlign="center" display="flex" fontWeight="bold">
              Condition
            </Text>
            <Select
              name="Condition"
              icon={<ChevronDownIcon />}
              variant="outline"
              size="md"
              onChange={(e)=> setCondition(e.target.value)}
              backgroundColor="#ffffff"
              color="#000000"
              bgGradient="linear(to right, #ffffff,#aeaeae)">
                <option value={"GOOD"}>GOOD</option>
                <option value={"USABLE"}>USABLE</option>
                <option value={"BAD"}>BAD</option>

                </Select>
          </Stack>
          <Stack spacing={2} mb={5}>
            <Text textAlign="center" display="flex" fontWeight="bold">
              Category
            </Text>
            <Select
              name="Category"
              icon={<ChevronDownIcon />}
              variant="outline"
              size="md"
              onChange={(e)=>setCategory(e.target.value)}
              backgroundColor="#ffffff"
              color="#000000"
              bgGradient="linear(to right, #ffffff,#aeaeae)">
                <option value={"CAR"}>CAR</option>
                <option value={"COMPUTER"}>COMPUTER</option>
                <option value={"SOFTWARE"}>SOFTWARE</option>
                <option value={"CLOTHE"}>CLOTHE</option>
                <option value={"BAG"}>BAG</option>
                <option value={"PHONE"}>PHONE</option>
                <option value={"TOY"}>TOY</option>



                </Select>
          </Stack>
          <Divider borderColor="blackAlpha.500" />
          <SimpleGrid columns={2} spacingX={100} spacingY={1} mt={10}>
            <Button
              variant="solid"
              size="md"
              textAlign="left"
              display="flex"
              borderRadius={8}
              backgroundColor="#707070"
              color="#ffffff"
              justifyContent="center"
              flexDirection="row"
              alignItems="center"
              colorScheme="whiteAlpha"
            >
              Cancel
            </Button>
            <Button
              variant="solid"
              size="md"
              textAlign="left"
              display="flex"
              borderRadius={8}
              backgroundColor="#028aff"
              color="#ffffff"
              justifyContent="center"
              flexDirection="row"
              alignItems="center"
              onClick={addit}
            >
              Add
            </Button>
          </SimpleGrid>
        </Grid>
      </Container>
    </Container>
  </ChakraProvider>
  )
}
export default Addit
