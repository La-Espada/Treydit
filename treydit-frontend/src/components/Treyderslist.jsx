
import { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import treyderService from '../services/treyder.service';

function TreydersList() {

  const [treyders, setTreyders] = useState([]);

  useEffect(() =>{
    console.log("bruh");
    treyderService.getAllTreyders()
    .then(response => {
      console.log('Printing the treyder data', response.data);
      setTreyders(response.data);
    })
    .catch(error =>{
      console.log('Something went wrong', error);
    })

  }, [])

  return (
    <div>
      <h1>Welcome to Treydit</h1>
      <h3>List of Treyders</h3>
      <Link to="/add" className='btn btn-primary mb-2'>Add Treyder</Link>
        <table border="1" cellPadding="10">
        
          <tr>
            
            <th>Username</th>
            <th>Firstname</th>
            <th>Lastname</th>
            <th>Gender</th>
            <th>Email</th>
            <th>Birthdate</th>
            <th>Reputation</th>
            <th>Street</th>
            <th>Housenumber</th>
            <th>Blocknumber</th>
            <th>Doornumber</th>
            <th>Zipcode</th>
            <th>Phonenumber</th>
            <th>Password</th>
            <th>Role</th>
            <th>City</th>
          </tr>
          {
            treyders.map(treyder => (
              <tr key={treyder.id}>
                <td>{treyder.username}</td>
                <td>{treyder.firstname}</td>
                <td>{treyder.lastname}</td>
                <td>{treyder.gender}</td>
                <td>{treyder.email}</td>
                <td>{treyder.birthDate}</td>
                <td>{treyder.reputation}</td>
                <td>{treyder.address.street}</td>
                <td>{treyder.address.housenumber}</td>
                <td>{treyder.address.blocknumber}</td>
                <td>{treyder.address.doornumber}</td>
                <td>{treyder.address.zipcode}</td>
                <td>{treyder.phonenumber}</td>
                <td>{treyder.password}</td>
                <td>{treyder.role}</td>
                <td>{treyder.city}</td>
              </tr>
            ))
          }
        </table>
     
      
    </div>
  );
}

export default TreydersList;