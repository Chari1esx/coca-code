import HomeView from '@/views/HomeView.vue'
import CpuLoad from "@/views/cpu/CpuLoad.vue";

export const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView,
  },
  {
    path: '/cpu',
    name: 'cpu',
    component: CpuLoad,
  },
]
