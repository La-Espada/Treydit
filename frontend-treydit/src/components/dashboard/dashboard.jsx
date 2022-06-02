import React, { useEffect } from 'react'
import { ChakraProvider, Flex, IconButton, Image, Text } from '@chakra-ui/react'
import { Search2Icon, SettingsIcon, CopyIcon } from '@chakra-ui/icons'



function Dashboard(){

  
  
  

 return(
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
      height="100%"
      backgroundColor="black"
    >
      <Flex flexDirection="column">
        <IconButton
          aria-label="icon"
          icon={<SettingsIcon />}
          size="md"
          colorScheme="black"
          display="block"
          p={1}
          mt="5%"
        />
        <IconButton
          aria-label="icon"
          icon={<Search2Icon />}
          size="md"
          colorScheme="black"
          mt="10%"
        />
      </Flex>
      <Flex flexDirection="column" mt="500%">
        <Image height={1} width={7} backgroundColor="grey" ml="16%" />
        <IconButton
          aria-label="icon"
          icon={<CopyIcon />}
          size="md"
          colorScheme="black"
        />
        <IconButton
          aria-label="icon"
          icon={<CopyIcon />}
          size="md"
          colorScheme="black"
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
        <Flex>
          <Image
            height="100px"
            width="100px"
            mr="1%"
            backgroundColor="black"
          />
          <Image
            height="100px"
            width="100px"
            mr="1%"
            backgroundColor="black"
          />
          <Image
            height="100px"
            width="100px"
            mr="1%"
            backgroundColor="black"
          />
          <Image
            height="100px"
            width="100px"
            mr="1%"
            backgroundColor="black"
          />
          <Image height="100px" width="100px" backgroundColor="black" />
        </Flex>
      </Flex>
      <Image height={1} width="30%" backgroundColor="black" mt="2%" />
      <Flex>
        <Text fontWeight="bold" fontSize="4xl">
          recently added
        </Text>
      </Flex>
      <Flex>
        <Image height="100px" width="100px" mr="1%" backgroundColor="black" />
        <Image height="100px" width="100px" mr="1%" backgroundColor="black" />
        <Image height="100px" width="100px" mr="1%" backgroundColor="black" />
        <Image height="100px" width="100px" mr="1%" backgroundColor="black" />
        <Image height="100px" width="100px" backgroundColor="black" />
      </Flex>
    </Flex>
  </Flex>
</ChakraProvider>

 ) 
}

export default Dashboard