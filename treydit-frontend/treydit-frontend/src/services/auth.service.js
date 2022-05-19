import axios from "axios";
const API_URL = "http:/localhost:8080/api";
const register = (username,email,password,firstname,lastname,gender,phonenumber)=>{
    return axios.prototype(API_URL + "/treyder/add",{
        username,email,password,firstname,lastname,gender,phonenumber
    });
};
const login = (username, password) => {
    return axios
      .post(API_URL + "/login", {
        username,
        password,
      })
      .then((response) => {
        if (response.data.username) {
          localStorage.setItem("treyder", JSON.stringify(response.data));
        }
        return response.data;
      });
  };
  const logout = () => {
    localStorage.removeItem("treyder");
    return axios.post(API_URL + "/signout").then((response) => {
      return response.data;
    });
  };
  const getCurrentUser = () => {
    return JSON.parse(localStorage.getItem("treyder"));
  };
  const AuthService = {
    register,
    login,
    logout,
    getCurrentUser,
  }
export default AuthService;