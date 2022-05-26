import axios from "axios";
const API_URL = "http://localhost:8080/api";

class AuthService{
  login(username,password){
    return axios.post(API_URL + "/login",{
      username,
      password
    })
    .then(response => {
      if (response.data.accessToken){
        localStorage.setItem("treyder", JSON.stringify(response.data));
      }
      return response.data;
    });
  }
  logout(){
    localStorage.removeItem("treyder");
  }
  register(username,firstname,lastname,email,gender,phonenumber,password){
    return axios.post(API_URL + "/register",{
      username,
      email,
      password,
      firstname,
      lastname,
      gender,
      phonenumber
    });
  }
  getCurrentUser(){
    return JSON.parse(localStorage.getItem("treyder"))
  }

}
export default new AuthService();