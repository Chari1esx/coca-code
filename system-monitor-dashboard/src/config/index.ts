import axios from "axios"

const request = axios.create({
  baseURL: 'http://localhost:8080',
  timeout: 3000,
})

request.interceptors.request.use(config => {
  return config
}, error => {
  return Promise.reject(error)
})

request.interceptors.response.use(resp => {
  return resp.data
}, error => {
  return Promise.reject(error)
})

export default request
