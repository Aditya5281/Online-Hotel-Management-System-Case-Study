import axios from "axios";
const API_URL = "http://localhost:8087/api/auth/";

class AuthService {
    login(username, password) {
        const response = axios.post(API_URL +"signin", {
                username,
                password
            });
        if (response.data.accessToken) {
            localStorage.setItem("user", JSON.stringify(axios.data));
        }
        return response.data;
    }


    register(username, email, password) {
        return axios.post(API_URL +"signup", {
            username,
            email,
            password
        });
    }

    getCurrentUser() {
        return JSON.parse(localStorage.getItem('user'));
    }
}

export default new AuthService();