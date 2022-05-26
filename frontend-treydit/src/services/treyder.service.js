import axios from "axios";
const API_URL = "http://localhost:8080/api"

class TreyderServices{

  getAllTreyder(){
    return axios.get(API_URL + "/treyder");
  }

  getTreyderBoard(){
    return axios.get(API_URL + "/",{ headers: authHeader() })
  }
  getModeratorBoard() {
    return axios.get(API_URL + 'mod', { headers: authHeader() });
  }
  getAdminBoard() {
    return axios.get(API_URL + 'admin', { headers: authHeader() });
  }
}

export default new TreyderServices;