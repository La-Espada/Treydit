import React from 'react'
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
  Icon
} from '@chakra-ui/react'
import { search, settings, copy, ArrowUpDownIcon, o } from '@chakra-ui/icons'

const Offer = () => (
  <ChakraProvider resetCSS>
    <Flex width="100%" height="100%">
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
          <IconButton
            aria-label="icon"
            size="md"
            colorScheme="black"
            display="block"
            p={1}
            mt="5%"
            backgroundColor="black"
            variantColor="white"
          />
          <IconButton
            aria-label="icon"
            size="md"
            colorScheme="black"
            mt="10%"
            variantColor="blcak"
          />
          <Avatar />
        </Flex>
        <Flex flexDirection="column" mt="700%">
          <Image height={1} width={7} backgroundColor="grey" ml="2%" mr="2%" />
          <IconButton
            aria-label="icon"
            size="md"
            colorScheme="black"
            variantColor="black"
          />
          <IconButton
            aria-label="icon"
            size="md"
            colorScheme="black"
            variantColor="black"
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
        <Flex>
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
              <Image
                height="100px"
                width="100px"
                display="flex"
                justifyContent="flex-start"
                m={2}
                minWidth={100}
                alt="item"
                minHeight={100}
                maxWidth={100}
                maxHeight={100}
                overflow="hidden"
                fallbackSrc="https://static.vecteezy.com/system/resources/previews/000/349/672/original/camera-vector-icon.jpg"
              />
              <Image
                height="100px"
                width="100px"
                display="flex"
                justifyContent="flex-start"
                m={2}
                minWidth={100}
                alt="item"
                minHeight={100}
                maxWidth={100}
                maxHeight={100}
                fallbackSrc="https://static.vecteezy.com/system/resources/previews/000/349/672/original/camera-vector-icon.jpg"
              />
              <Image
                height="100px"
                width="100px"
                display="flex"
                justifyContent="flex-start"
                m={2}
                minWidth={100}
                alt="item"
                minHeight={100}
                maxWidth={100}
                maxHeight={100}
                overflow="hidden"
                fallbackSrc="https://static.vecteezy.com/system/resources/previews/000/349/672/original/camera-vector-icon.jpg"
              />
              <Image
                height="100px"
                width="100px"
                display="flex"
                justifyContent="flex-start"
                m={2}
                minWidth={100}
                alt="item"
                minHeight={100}
                maxWidth={100}
                maxHeight={100}
                overflow="hidden"
                fallbackSrc="https://static.vecteezy.com/system/resources/previews/000/349/672/original/camera-vector-icon.jpg"
              />
            </Grid>
          </Container>
        </Flex>
        <Container overflow="visible" display="block">
          <Container>
            <Heading color="#ffffff">Username 1</Heading>
            <Text color="#ffffff">you offer...</Text>
            <Grid
              templateColumns="repeat(3, 1fr)"
              gap={3}
              display="grid"
              overflow="visible"
              backgroundColor="#0d0d0d"
              borderRadius={10}
            >
              <Image
                height="100px"
                width="100px"
                display="flex"
                justifyContent="flex-start"
                m={2}
                minWidth={100}
                alt="item"
                minHeight={100}
                maxWidth={100}
                maxHeight={100}
                overflow="hidden"
                fallbackSrc="https://static.vecteezy.com/system/resources/previews/000/349/672/original/camera-vector-icon.jpg"
              />
              <Image
                height="100px"
                width="100px"
                display="flex"
                justifyContent="flex-start"
                m={2}
                minWidth={100}
                alt="item"
                minHeight={100}
                maxWidth={100}
                maxHeight={100}
                fallbackSrc="https://static.vecteezy.com/system/resources/previews/000/349/672/original/camera-vector-icon.jpg"
              />
              <Image
                height="100px"
                width="100px"
                display="flex"
                justifyContent="flex-start"
                m={2}
                minWidth={100}
                alt="item"
                minHeight={100}
                maxWidth={100}
                maxHeight={100}
                overflow="hidden"
                fallbackSrc="https://static.vecteezy.com/system/resources/previews/000/349/672/original/camera-vector-icon.jpg"
              />
            </Grid>
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
              mt={5}
              bgGradient="linear(to bottom right, green.200,blue.500)"
              borderRadius={10}
            >
              make offer
            </Button>
            <ArrowUpDownIcon boxSize={20} display="block" />
            <o />
          </Flex>
          <Container>
            <Heading color="#ffffff">Username 2</Heading>
            <Text color="#ffffff">you receive...</Text>
            <Grid
              templateColumns="repeat(3, 1fr)"
              gap={3}
              display="grid"
              overflow="visible"
              backgroundColor="#0d0d0d"
              borderRadius={10}
            >
              <Image
                height="100px"
                width="100px"
                display="flex"
                justifyContent="flex-start"
                m={2}
                minWidth={100}
                alt="item"
                minHeight={100}
                maxWidth={100}
                maxHeight={100}
                overflow="hidden"
                fallbackSrc="https://static.vecteezy.com/system/resources/previews/000/349/672/original/camera-vector-icon.jpg"
              />
              <Image
                height="100px"
                width="100px"
                display="flex"
                justifyContent="flex-start"
                m={2}
                minWidth={100}
                alt="item"
                minHeight={100}
                maxWidth={100}
                maxHeight={100}
                fallbackSrc="https://static.vecteezy.com/system/resources/previews/000/349/672/original/camera-vector-icon.jpg"
              />
              <Image
                height="100px"
                width="100px"
                display="flex"
                justifyContent="flex-start"
                m={2}
                minWidth={100}
                alt="item"
                minHeight={100}
                maxWidth={100}
                maxHeight={100}
                overflow="hidden"
                fallbackSrc="https://static.vecteezy.com/system/resources/previews/000/349/672/original/camera-vector-icon.jpg"
              />
            </Grid>
          </Container>
        </Container>
      </Flex>
    </Flex>
  </ChakraProvider>
)

export default Offer