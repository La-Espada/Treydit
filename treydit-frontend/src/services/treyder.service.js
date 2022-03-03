import httpClient from '../http-common';

const getAllTreyders = () => {
    return httpClient.get('/treyder/');
}

export default {getAllTreyders};