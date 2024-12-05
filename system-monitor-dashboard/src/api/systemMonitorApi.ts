import request from '@/config'

const getCpuLoad = () => {
  return request.get('/system/cpu/load')
}

export {
  getCpuLoad,
}
