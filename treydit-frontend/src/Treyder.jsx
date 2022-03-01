import React, {useState} from 'react';
import Box from '@material-ui/core/Box';
import TextField from '@material-ui/core/TextField';
import { Container, Paper,Button } from '@material-ui/core';


export default function Treyder() {
  const paperStyle ={padding:'50px 20px', width:600, margin:"20px auto"}
  const[Firstname,setFirstname]= useState('')
  const[Subname,setSubname]= useState('')
  const[Lastname,setLastname]= useState('')
  const[Gender,setGender] = useState('')
  const[Username, setUsername] = useState('')
  const[Email, setEmail] = useState('')
  const[Birthdate, setBirthdate] = useState('')
  const[Addressname, setAddressname] = useState('')
  const[Housenumber, setHousenumber] = useState('')
  const[Blocknumber, setBlocknumber] = useState('')
  const[Doornumber, setDoornumber] = useState('')
  const[Zipcode, setZipcode] = useState('')
  const[Countrycode, setCountrycode] = useState('')
  const[Serialnumber, setSerialnumber] = useState('')
  const[Password, setPassword] = useState('')
  const[Role, setRole] = useState('')
  const[City, setCity] = useState('')

  const handleClick = (e) => {
      e.preventDefault()
      const treyder = {Firstname,Subname,Lastname,Gender,Username,Email,Birthdate,Addressname,Housenumber,Blocknumber,Doornumber,Zipcode,Countrycode,Serialnumber
    ,Password,Role,City}
      console.log(treyder);
      fetch("http://localhost:8080/api/treyder/add",{
          method:"POST",
          headers:{"Content-Type": "application/json",
          body:JSON.stringify(treyder)
        }
      }).then(()=>{

        console.log("New student added")
      })
  }

  return (
    <Container>
      <Paper elevation={3} style={paperStyle}>
        <h1 style={{color:"violet"}}><u>Add Treyder</u></h1>
      
    <Box
      component="form"
      sx={{
        '& > :not(style)': { m: 1, width: '25ch' },
      }}
      noValidate
      autoComplete="off"
    >
      <TextField id="outlined-basic" label="Firstname" variant="outlined" fullWidth 
      value={Firstname}
      onChange={(e) => setFirstname(e.target.value)}
      />
      <TextField id="outlined-basic" label="Subname" variant="outlined" fullWidth
       value={Subname}
       onChange={(e) => setSubname(e.target.value)}
      />
      <TextField id="outlined-basic" label="Lastname" variant="outlined" fullWidth
       value={Lastname}
       onChange={(e) => setLastname(e.target.value)}
      />
    
      <TextField id="outlined-basic" label="Gender" variant="outlined" fullWidth
       value = {Gender}
       onChange = {(e) => setGender(e.target.value)}
      />
      <TextField id="outlined-basic" label="Username" variant="outlined" fullWidth
       value = {Username}
       onChange = {(e) => setUsername(e.target.value)}
      />
      <TextField id="outlined-basic" label="Email" variant="outlined" fullWidth
       value = {Email}
       onChange = {(e) => setEmail(e.target.value)}
      />
      <TextField id="outlined-basic" label="Birthdate" variant="outlined" fullWidth
       value = {Birthdate}
       onChange = {(e)=> setBirthdate(e.target.value)}
      />
      <TextField id="outlined-basic" label="Address name" variant="outlined" fullWidth
       value={Addressname}
       onChange = {(e) => setAddressname(e.target.value)}
      />
      <TextField id="outlined-basic" label="Housenumber" variant="outlined" fullWidth
       value = {Housenumber}
       onChange = {(e) => setHousenumber}
      />
      <TextField id="outlined-basic" label="Blocknumber" variant="outlined" fullWidth
       value = {Blocknumber}
       onChange = {(e) => setBlocknumber}
      />
      <TextField id="outlined-basic" label="Doornumber" variant="outlined" fullWidth
       value =  {Doornumber}
       onChange = {(e) => setDoornumber}
      />
      <TextField id="outlined-basic" label="Zipcode" variant="outlined" fullWidth
       value = {Zipcode}
       onChange = {(e) => setZipcode}
      />
      <TextField id="outlined-basic" label="Country code" variant="outlined" fullWidth
       value = {Countrycode}
       onChange = {(e) => setCountrycode}
      />
      <TextField id="outlined-basic" label="Serialnumber" variant="outlined" fullWidth
       value = {Serialnumber}
       onChange = {(e) => setSerialnumber}
      />
      <TextField id="outlined-basic" label="Password" variant="outlined" fullWidth
       value={Password}
       onChange = {(e) => setPassword}
      />
      <TextField id="outlined-basic" label="Role" variant="outlined" fullWidth
       value = {Role}
       onChange = {(e) => setRole}
      />
      <TextField id="outlined-basic" label="City" variant="outlined" fullWidth
       value = {City}
       onChange = {(e) => setCity}
      />



    </Box>
    
    <Button variant="contained" onClick={handleClick}>Submit</Button>

    {Firstname}
    {Subname}
    {Lastname}
    {Gender}
    {Username}
    {Email}
    {Birthdate}
    {Addressname}
    {Housenumber}
    {Blocknumber}
    {Doornumber}
    {Zipcode}
    {Countrycode}
    {Serialnumber}
    {Password}
    {Role}
    {City}
    </Paper>
    </Container>
  );
}
