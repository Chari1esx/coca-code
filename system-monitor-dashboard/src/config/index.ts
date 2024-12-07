import axios from "axios"

const client = axios.create({
  baseURL: 'http://localhost:8080',
  timeout: 3000,
})

client.interceptors.request.use(config => {
  return config
}, error => {
  return Promise.reject(error)
})

client.interceptors.response.use(resp => {
  return resp.data
}, error => {
  return Promise.reject(error)
})

export default client
