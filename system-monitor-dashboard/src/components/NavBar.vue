<script setup lang="ts">
import { h, ref } from 'vue'
import { HomeOutlined, MonitorOutlined } from '@ant-design/icons-vue'
import type { MenuProps } from 'ant-design-vue'
import { useRouter } from 'vue-router'

const router = useRouter()

const handleMenuClick = ({ key }: { key: string }) => {
  router.push({ path: key })
}

const current = ref<string[]>([])
router.afterEach((to) => {
  current.value = [to.path]
})

const items = ref<MenuProps['items']>([
  {
    key: '/',
    icon: () => h(HomeOutlined),
    label: 'dashboard',
    title: 'Dashboard',
  },
  {
    key: '/cpu',
    icon: () => h(MonitorOutlined),
    label: 'cpu',
    title: 'CPU',
  },
])
</script>

<template>
  <div class="nav-container">
    <div class="logo">
      <img src="@/assets/charless.svg" alt="logo" />
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
