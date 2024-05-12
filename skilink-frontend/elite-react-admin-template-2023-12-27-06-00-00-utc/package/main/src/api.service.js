import axios from 'axios';

const API = axios.create({
  baseURL: 'http://localhost:8080/api', // Adjust the base URL as needed
});

// Function to fetch projects
const fetchProjects = async () => {

    try{
    const response = await API.get('/projects');

   return response.data;
    }catch(error){
        console.error('Failed to fetch theme settings:', error);
        throw error; // Throw error to handle it in the component or context provider
    }

}

const apiService ={
    fetchProjects: () => fetchProjects(),
}


export default apiService;