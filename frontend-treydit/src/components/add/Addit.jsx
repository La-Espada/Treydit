import React from 'react'
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
  IconButton,
  SimpleGrid
} from '@chakra-ui/react'
import { AddIcon } from '@chakra-ui/icons'

const Addit = () => (
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
              fallbackSrc="https://static.vecteezy.com/system/resources/previews/000/349/672/original/camera-vector-icon.jpg"
              backgroundColor="#ffffff"
            />
            <IconButton
              aria-label="icon"
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
            <Input />
            <FormHelperText>Add the name of your item.</FormHelperText>
            <FormErrorMessage>Error message</FormErrorMessage>
          </FormControl>
          <FormControl mb={5}>
            <FormLabel>Description</FormLabel>
            <Textarea />
            <FormHelperText>Add a description.</FormHelperText>
            <FormErrorMessage>Error message</FormErrorMessage>
          </FormControl>
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
            >
              Add
            </Button>
          </SimpleGrid>
        </Grid>
      </Container>
    </Container>
  </ChakraProvider>
)

export default Addit
