<script setup lang="ts">
import NavBar from '@/components/NavBar.vue'
import type { CSSProperties } from 'vue'

const layoutStyle: CSSProperties = {
  minHeight: '100vh',
}
const contentStyle: CSSProperties = {
  minHeight: 120,
  lineHeight: '120px',
  backgroundColor: '#fff',
}
</script>

<template>
  <a-layout :style="layoutStyle">
    <a-layout-header>
      <NavBar />
    </a-layout-header>
    <a-layout-content :style="contentStyle">
      <RouterView />
    </a-layout-content>
  </a-layout>
</template>

<style scoped></style>
