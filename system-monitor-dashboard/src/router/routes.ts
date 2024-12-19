import DashboardView from '@/views/DashboardView.vue'
import CpuLoadView from '@/views/cpu/CpuLoadView.vue'

export const routes = [
  {
    path: '/',
    name: 'dashboard',
    component: DashboardView,
  },
  {
    path: '/cpu',
    name: 'cpu',
    component: CpuLoadView,
  },
]
