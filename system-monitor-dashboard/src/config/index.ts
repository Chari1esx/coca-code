import axios from 'axios'

const client = axios.create({
  baseURL: 'http://localhost:7071/api',
  timeout: 5000,
})

client.interceptors.request.use(
  (config) => {
    return config
  },
  (err) => {
    return Promise.reject(err)
  },
)

client.interceptors.response.use(
  (resp) => {
    return resp.data
  },
  (err) => {
    return Promise.reject(err)
  },
)

export default client
