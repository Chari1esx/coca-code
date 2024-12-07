<script setup lang="ts">
import {h, onMounted, ref, watch} from 'vue'
import { HomeOutlined, MonitorOutlined } from '@ant-design/icons-vue'
import type { MenuProps } from 'ant-design-vue'
import { useRoute, useRouter } from 'vue-router'

const router = useRouter()
const route = useRoute()

const handleMenuClick = ({ key }: { key: string }) => {
  switch (key) {
    case 'dashboard':
      router.push({ name: 'home' })
      break
    case 'cpu':
      router.push({ name: 'cpu' })
      break
  }
}
const getCurrentMenuKey = (): string => {
  return route.path === '/cpu' ? 'cpu' : 'dashboard'
}

const current = ref<string[]>([])

onMounted(() => {
  current.value = [getCurrentMenuKey()]
})

watch(
  () => route.path,
  (newPath) => {
    console.log('Route path changed to:', newPath)
    current.value = [getCurrentMenuKey()]
  },
)

const items = ref<MenuProps['items']>([
  {
    key: 'dashboard',
    icon: () => h(HomeOutlined),
    label: 'Dashboard',
    title: 'Dashboard',
  },
  {
    key: 'cpu',
    icon: () => h(MonitorOutlined),
    label: 'CPU',
    title: 'CPU',
  },
])
</script>

<template>
  <div class="nav-container">
    <div class="logo">
      <img src="@/assets/charless.svg" alt="" />
    </div>
    <a-menu
      v-model:selectedKeys="current"
      mode="horizontal"
      :style="{ lineHeight: '64px' }"
      :items="items"
      @click="handleMenuClick"
      class="menu"
    />
  </div>
</template>

<style scoped>
.nav-container {
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 0 40px;
  box-sizing: border-box;
  width: 100%;
  background-color: #fff;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
  position: fixed;
  top: 0;
  left: 0;
  z-index: 1000;
}

.logo {
  display: flex;
  align-items: center;
}

.logo img {
  height: auto;
  max-height: 64px;
  margin-right: 20px;
}

.menu {
  flex-grow: 1;
  display: flex;
  justify-content: flex-start;
}
</style>
