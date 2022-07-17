import axios from 'axios';
import authHeader from './AuthHeader';

const API_URL = 'http://localhost:8087/api/test/';

class UserService {
  getPublicContent() {
    return axios.get(API_URL + 'all');
  }

  getUser() {
    return axios.get(API_URL + 'user', { headers: authHeader() });
  }

  getReceptionist() {
    return axios.get(API_URL + 'receptionist', { headers: authHeader() });
  }

  getManager() {
    return axios.get(API_URL + 'manager', { headers: authHeader() });
  }

  getOwner() {
    return axios.get(API_URL + 'owner', { headers: authHeader() });
  }

}

export default new UserService();