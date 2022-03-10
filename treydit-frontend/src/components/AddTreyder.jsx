import { useState } from "react";
import { Navigate, useNavigate } from "react-router-dom";
import treyderService from "../services/treyder.service";

const AddTreyder = () => {

    const [username, setUsername] = useState('');
    const [firstname, setFirstname] = useState('');
    const [lastname, setLastname] = useState('');
    const [gender, setGender] = useState('');
    const [email, setEmail] = useState('');
    const [birthDate,setBirthdate] = useState(''); 
    const [street, setStreet] = useState('');
    const [housenumber, setHousenumber] = useState('');
    const [blocknumber, setBlocknumber] = useState('');
    const [doornumber, setDoornumber] = useState('');
    const [countryCode, setCountryCode] = useState('');
    const [serialNumber, setSerialNumber] = useState('');
    const [zipcode, setZipcode] = useState('');
    const [password, setPassword] = useState('');
    const [role, setRole] = useState('');
    const [city, setCity] = useState('');
    const history = useNavigate();

    const saveTreyder = (e) =>{
       e.preventDefault();


       const address ={street,housenumber,blocknumber,doornumber,zipcode,};
       const phonenumber={countryCode,serialNumber};
       const treyder = {username,firstname,lastname,gender,email,birthDate,address,phonenumber,password,role,};
       treyderService.create(treyder)
       .then(response =>{
           console.log('Treyder data added successfully',response.data);
          Navigate('/');
       } )
       .catch(error =>{
           console.log('Something went wrong', error);
       });
    }



    return(
        <div className="container">
            <h1>Add new Treyder</h1>
            <hr/>
            <form>
                <div className="form-group">
                    <input
                     type="text"
                     className="form-control col-4"
                     id="firstname"
                     value={firstname}
                     onChange = {(e) =>setFirstname(e.target.value)}
                     placeholder = "Enter your Firstname"
                    />
                    </div>
                    <div className="form-group">
                    <input
                     type="text"
                     className="form-control col-4"
                     id="lastname"
                     value={lastname}
                     onChange = {(e) =>setLastname(e.target.value)}
                     placeholder = "Enter your Lastname"
                    />
                    </div>
                    <div className="form-group">
                    <input
                     type="text"
                     className="form-control col-4"
                     id="username"
                     value={username}
                     onChange = {(e) =>setUsername(e.target.value)}
                     placeholder = "Enter your Username"
                    />
                    </div>
                     <div className="form-group">
                   <input
                     type="text"
                     className="form-control col-4"
                     id="Gender"
                     value={gender}
                     onChange = {(e) =>setGender(e.target.value)}
                     placeholder="Enter your gender"
                    >
                    </input>
                    </div>
                    <div className="form-group">
                    <input
                     type="text"
                     className="form-control col-4"
                     id="Email"
                     value={email}
                     onChange = {(e) =>setEmail(e.target.value)}
                     placeholder = "Enter your Email"
                    />
                     </div>
                     <div className="form-group">
                      <input
                     type="text"
                     className="form-control col-4"
                     id="Password"
                     value={password}
                     onChange = {(e) =>setPassword(e.target.value)}
                     placeholder = "Enter your Password"
                    />
                  </div>
                  <div className="form-group">
                    <input
                     type="text"
                     className="form-control col-4"
                     id="Birthdate"
                     value={birthDate}
                     onChange = {(e) =>setBirthdate(e.target.value)}
                     placeholder = "Select your Birthdate"
                    />
                    </div>
                    <div className="form-group">
                    <input
                     type="text"
                     className="form-control col-4"
                     id="Street"
                     value={street}
                     onChange = {(e) =>setStreet(e.target.value)}
                     placeholder = "Enter your Street"
                    />
                    </div>
                    <div className="form-group">
                      <input
                     type="text"
                     className="form-control col-4"
                     id="Housenumber"
                     value={housenumber}
                     onChange = {(e) =>setHousenumber(e.target.value)}
                     placeholder = "Enter your Housenumber"
                    />
                    </div>
                    <div className="form-group">
                      <input
                     type="text"
                     className="form-control col-4"
                     id="Blocknumber"
                     value={blocknumber}
                     onChange = {(e) =>setBlocknumber(e.target.value)}
                     placeholder = "Enter your Blocknumber"
                    />
                     </div>
                     <div className="form-group">
                      <input
                     type="text"
                     className="form-control col-4"
                     id="Doornumber"
                     value={doornumber}
                     onChange = {(e) =>setDoornumber(e.target.value)}
                     placeholder = "Enter your Doornumber"
                    />
                    </div>
                    <div className="form-group">
                      <input
                     type="text"
                     className="form-control col-4"
                     id="Zipcode"
                     value={zipcode}
                     onChange = {(e) =>setZipcode(e.target.value)}
                     placeholder = "Enter your Zipcode"
                    />
                     </div>
                     <div className="form-group">
                      <input
                     type="text"
                     className="form-control col-4"
                     id="Role"
                     value={role}
                     onChange = {(e) =>setRole(e.target.value)}
                     placeholder = "Enter your Role"
                    />
                    </div>
                    <div className="form-group">
                      <input
                     type="text"
                     className="form-control col-4"
                     id="country_code"
                     value={countryCode}
                     onChange = {(e) =>setCountryCode(e.target.value)}
                     placeholder = "Enter your Country"
                    />
                    </div>
                    <div className="form-group">
                      <input
                     type="text"
                     className="form-control col-4"
                     id="Serialnumber"
                     value={serialNumber}
                     onChange = {(e) =>setSerialNumber(e.target.value)}
                     placeholder = "Enter your Serialnumber"
                    />
                    </div>
                    
                <div>
                    <button className="btn btn-primary" onClick={(e) => saveTreyder(e)}>Save</button>
                </div>
            </form>
        </div>
    );
}

export default AddTreyder;