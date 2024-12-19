import Dashboard from '@/views/Dashboard.vue'
import CpuLoad from '@/views/cpu/CpuLoad.vue'

export const routes = [
  {
    path: '/',
    name: 'dashboard',
    component: Dashboard,
  },
  {
    path: '/cpu',
    name: 'cpu',
    component: CpuLoad,
  },
]
