import { useState } from "react";

const AddTreyder = () => {

    const [username, setUsername] = useState('');
    const [firstname, setFirstname] = useState('');
    const [lastname, setLastname] = useState('');
    const [gender, setGender] = useState('');
    const [email, setEmail] = useState('');
    const [birthDate,setBirthdate] = useState('');
    const [reputation, setReputation] = useState('');
    const [street, setStreet] = useState('');
    const [housenumber, setHousenumber] = useState('');
    const [blocknumber, setBlocknumber] = useState('');
    const [doornumber, setDoornumber] = useState('');
    const [zipcode, setZipcode] = useState('');
    const [password, setPassword] = useState('');
    const [role, setRole] = useState('');
    const [city, setCity] = useState('');



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
            </form>
        </div>
    );
}

export default AddTreyder;