import client from '@/config'

const getCpuLoad = () => {
  return client.get('/system/cpu/load')
}

export { getCpuLoad }
