import httpClient from '../http-common';

const getAllTreyders = () => {
    return httpClient.get('/treyder/');
}

const create = (data) =>{
   return httpClient.post("/treyder/",data);
}

export default {getAllTreyders, create};