import React from "react";
import {
  ChakraProvider,
  Box,
  Image,
  Divider,
  Text,
  Button,
  Center
} from "@chakra-ui/react";

const Icon = () => (
  <ChakraProvider resetCSS>
    <Box
      border="2px"
      borderRadius="10px"
      backgroundColor="#000000"
      width="200px"
      height={275}
      p={0}
      m={5}
    >
      <Image
        height="60%"
        width="100%"
        src="https://cdn-1.debijenkorf.at/web_detail/balenciaga-speed-3-0-sneaker-mit-logo/?reference=034/750/13_0347507002125400_pro_flt_frt_01_1108_1528_5820517.jpg"
        objectFit="cover"
        borderRadius="10px"
      />
      <Box
        display="flex"
        alignItems="stretch"
        flexDirection="column"
        justifyContent="center"
      >
        <Center mt="7px" mb="2px">
          <Divider
            borderColor="#ffffff"
            mt="2px"
            mb="2px"
            width="75%"
            textAlign="left"
          />
        </Center>
        <Text color="#ffffff" textAlign="center">
          BALENCJAGA
        </Text>
        <Text color="#ffffff" textAlign="center" fontSize="sm">
          for trade
        </Text>
        <Center>
          <Divider
            borderColor="#ffffff"
            mt="2px"
            mb="7px"
            width="75%"
            textAlign="left"
          />
        </Center>
        <Button
          _hover={{
            bgGradient: "linear(to-b, white, grey)",
            transition: "bgGradient 200ms linear"
          }}
          _focus={{
            textDecor: "none",
            background: "white"
          }}
          variant="solid"
          size="md"
          height="35px"
          ml="5px"
          mr="5px"
        >
          make trade offer
        </Button>
      </Box>
    </Box>
  </ChakraProvider>
);S

export default Icon;
