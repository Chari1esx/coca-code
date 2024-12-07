<script setup lang="ts">
import * as echarts from 'echarts'

type EChartsOption = echarts.EChartsOption
type ECharts = echarts.ECharts

import { onMounted, ref } from 'vue'
import { getCpuLoad } from '@/api/systemMonitorApi.ts'

const chartDom = ref<ECharts[]>([])

onMounted(() => {
  initChart()
  getCpuData()
})

const initChart = () => {
  for (let i = 0; i < 8; i++) {
    const dom = document.getElementById(`cpu-${i + 1}`)
    const myChart = echarts.init(dom) // chart 对象
    chartDom.value.push(myChart)
  }
}

const allCpuData = ref<number[][]>([])

const getCpuData = async () => {
  const resp = await getCpuLoad()
  const data = resp.data
  for (let i = 0; i < data.length; i++) {
    if (!allCpuData.value[i]) {
      allCpuData.value[i] = []
    }

    if (allCpuData.value[i].length > 10) {
      const arr = allCpuData.value[i].splice(-10)
      arr.push(data[i])
      allCpuData.value[i] = arr
    } else {
      allCpuData.value[i].push(data[i])
    }
    drawCpuLoad(i + 1, allCpuData.value[i])
  }
  await getCpuData()
}

const drawCpuLoad = (cpuIndex: number, cpuData: number[]) => {
  const myChart = chartDom.value[cpuIndex - 1]
  const option: EChartsOption = {
    title: {
      show: true,
      text: `CPU-${cpuIndex}`,
      textStyle: {
        fontSize: '14px',
      },
    },
    grid: {
      left: '0',
      right: '0',
      bottom: '5',
      top: '0',
    },
    xAxis: {
      show: false,
      type: 'category',
    },
    yAxis: {
      show: false,
      type: 'value',
      min: 0,
      max: 1,
    },
    series: [
      {
        data: cpuData,
        type: 'line',
        symbol: 'none',
        smooth: true,
        areaStyle: {},
      },
    ],
  }
  myChart.setOption(option)
}
</script>

<template>
  <a-space wrap class="cpu-load-container">
    <div
      :key="i"
      :id="`cpu-${i}`"
      style="width: 320px; height: 320px; border: 1px solid black"
      v-for="i in 8"
    />
  </a-space>
</template>

<style scoped>
.cpu-load-container {
  padding: 20px;
  display: flex;
  align-items: center;
  justify-content: center;
}
</style>
